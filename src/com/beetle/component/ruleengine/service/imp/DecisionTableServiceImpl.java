package com.beetle.component.ruleengine.service.imp;

import java.util.List;

import org.easyrules.api.RulesEngine;
import org.easyrules.core.CompositeRule;
import org.easyrules.core.RulesEngineBuilder;
import org.slf4j.Logger;

import com.beetle.component.ruleengine.dto.Conclusion;
import com.beetle.component.ruleengine.dto.Factor;
import com.beetle.component.ruleengine.dto.Request;
import com.beetle.component.ruleengine.dto.Response;
import com.beetle.component.ruleengine.dto.Rule;
import com.beetle.component.ruleengine.dto.RuleGroup;
import com.beetle.component.ruleengine.persistence.ConclusionDao;
import com.beetle.component.ruleengine.persistence.FactorDao;
import com.beetle.component.ruleengine.persistence.RuleDao;
import com.beetle.component.ruleengine.persistence.RuleGroupDao;
import com.beetle.component.ruleengine.service.DecisionTableService;
import com.beetle.component.ruleengine.service.RuleEngineServiceException;
import com.beetle.framework.AppProperties;
import com.beetle.framework.log.AppLogger;
import com.beetle.framework.persistence.access.operator.DBOperatorException;
import com.beetle.framework.resource.dic.def.DaoField;
import com.beetle.framework.resource.dic.def.ServiceTransaction;
import com.beetle.framework.util.cache.ICache;

public class DecisionTableServiceImpl implements DecisionTableService {
	private static Logger logger = AppLogger.getLogger(DecisionTableServiceImpl.class);
	@DaoField
	private RuleGroupDao ruleGroupDao;
	@DaoField
	private RuleDao ruleDao;
	@DaoField
	private FactorDao factorDao;
	@DaoField
	private ConclusionDao conclusionDao;

	@ServiceTransaction
	@Override
	public void createRuleGroup(RuleGroup ruleGroup) throws RuleEngineServiceException {
		if (ruleGroup.getRuleList() == null || ruleGroup.getRuleList().isEmpty()) {
			throw new RuleEngineServiceException(-101, "规则列表不能为空");
		}
		try {
			long gid = ruleGroupDao.insert(ruleGroup);
			List<Rule> ruleList = ruleGroup.getRuleList();
			for (Rule rule : ruleList) {
				rule.setGid(gid);
				long rid = ruleDao.insert(rule);
				List<Factor> factorList = rule.getFactorList();
				if (factorList == null || factorList.isEmpty()) {
					throw new RuleEngineServiceException(-102, "规则的条件决策因子不能为空");
				}
				for (Factor factor : factorList) {
					factor.setRuleId(rid);
					factorDao.insert(factor);
				}
				List<Conclusion> conclusionList = rule.getConclusionList();
				if (conclusionList == null || conclusionList.isEmpty()) {
					throw new RuleEngineServiceException(-103, "规则的结论不能为空");
				}
				for (Conclusion conclusion : conclusionList) {
					conclusion.setRuleId(rid);
					conclusionDao.insert(conclusion);
				}
			}
		} catch (Exception e) {
			throw new RuleEngineServiceException(-110, e);
		}
	}

	@Override
	public RuleGroup queryRuleGroup(long ruleGroupId) throws RuleEngineServiceException {
		RuleGroup rg = null;
		if (CacheHelper.isCacheFlag()) {
			ICache cache = CacheHelper.getGROUPCACHE();
			rg = (RuleGroup) cache.get(ruleGroupId);
			if (rg != null) {
				logger.debug("from cache:{}", ruleGroupId);
				return rg;
			}
		}
		try {
			rg = ruleGroupDao.get(ruleGroupId);
			if (rg == null) {
				return rg;
			}
			List<Rule> rules = ruleDao.getRulesByGroupId(rg.getGid());
			if (rules == null || rules.isEmpty()) {
				throw new RuleEngineServiceException(-101, "没有规则定义，错误的数据，请检查");
			}
			for (Rule rule : rules) {
				if (rule.getStatus() == 1) {// 有效的
					List<Factor> factors = factorDao.getByRuleId(rule.getRuleId());
					if (factors == null || factors.isEmpty()) {
						throw new RuleEngineServiceException(-102, "没有规则条件因子定义，错误的数据，请检查");
					}
					for (Factor factor : factors) {// 有效的
						if (factor.getStatus() == 1) {
							rule.addFactor(factor);
						}
					}
					List<Conclusion> conclusions = conclusionDao.getByRuleId(rule.getRuleId());
					if (conclusions == null || conclusions.isEmpty()) {
						throw new RuleEngineServiceException(-103, "没有规则结论因子定义，错误的数据，请检查");
					}
					for (Conclusion conclusion : conclusions) {
						if (conclusion.getStatus() == 1) {// 有效的
							rule.addConclusion(conclusion);
						}
					}
					rg.addRule(rule);
				}
			}
			if (CacheHelper.isCacheFlag()) {
				ICache cache = CacheHelper.getGROUPCACHE();
				cache.put(ruleGroupId, rg);
				logger.debug("put into cache:{}", ruleGroupId);
			}
			return rg;
		} catch (DBOperatorException dbe) {
			throw new RuleEngineServiceException(-110, dbe);
		}
	}

	@Override
	public Response execute(Request request) throws RuleEngineServiceException {
		logger.debug("begin,req:{}", request);
		RuleGroup rg = this.queryRuleGroup(request.getRuleGroupId());
		if (rg == null) {
			throw new RuleEngineServiceException(-101, "没有此规则组的定于，请检查");
		}
		Response response = new Response();
		response.setMatch(false);
		RulesEngine engine = RulesEngineBuilder.aNewRulesEngine().named(rg.getName())
				.withSkipOnFirstAppliedRule(AppProperties.getAsBoolean("ruleEngine_withSkipOnFirstAppliedRule", true))
				.withSkipOnFirstFailedRule(AppProperties.getAsBoolean("ruleEngine_withSkipOnFirstFailedRule", true))
				.withSilentMode(AppProperties.getAsBoolean("ruleEngine_withSilentMode", false)).build();
		List<Rule> rules = rg.getRuleList();
		for (Rule rule : rules) {
			List<Factor> factors = rule.getFactorList();
			CompositeRule cpsr = new CompositeRule(rule.getName(), rule.getDescp());
			for (Factor factor : factors) {
				DecisionTableRule dtr = new DecisionTableRule(rule.getName(), factor, request.get(factor.getVariate()));
				cpsr.addRule(dtr);
				logger.debug("factor:{},{}", factor.getVariate(), factor.getBoolExpression());
			}
			DecisionTableLastRule dtlr = new DecisionTableLastRule(rule.getName(), rule.getRuleId(),
					rule.getConclusionList(), response);
			cpsr.addRule(dtlr);
			engine.registerRule(cpsr);
			logger.debug("engine register:{},{}", rule.getRuleId(), rule.getName());
		}
		engine.fireRules();
		logger.debug("ruleegine fired!");
		logger.debug("end,result:{},{}", response.isMatch(), response);
		return response;
	}

	@ServiceTransaction
	@Override
	public void deleteRuleGroup(long ruleGroupId) throws RuleEngineServiceException {
		RuleGroup rg = this.queryRuleGroup(ruleGroupId);
		if (rg == null)
			return;
		try {
			ruleGroupDao.delete(rg.getGid());
			List<Rule> rules = rg.getRuleList();
			for (Rule rule : rules) {
				ruleDao.delete(rule.getRuleId());
				List<Factor> factors = rule.getFactorList();
				for (Factor factor : factors) {
					factorDao.delete(factor.getFid());
				}
				List<Conclusion> conclusions = rule.getConclusionList();
				for (Conclusion c : conclusions) {
					conclusionDao.delete(c.getCId());
				}
			}
		} catch (DBOperatorException dbe) {
			throw new RuleEngineServiceException(-110, dbe);
		}
	}

	@ServiceTransaction
	@Override
	public void createRuleToRuleGroup(Rule rule) throws RuleEngineServiceException {
		try {
			long ruleid = ruleDao.insert(rule);
			List<Factor> factors = rule.getFactorList();
			for (Factor factor : factors) {
				factor.setRuleId(ruleid);
				factorDao.insert(factor);
			}
			List<Conclusion> conclusions = rule.getConclusionList();
			for (Conclusion c : conclusions) {
				c.setRuleId(ruleid);
				conclusionDao.insert(c);
			}
		} catch (DBOperatorException dbe) {
			throw new RuleEngineServiceException(-110, dbe);
		}
	}

	@ServiceTransaction
	@Override
	public void deleteRuleFromRuleGroup(long ruleId) throws RuleEngineServiceException {
		try {
			ruleDao.delete(ruleId);
			factorDao.deleteByRuleId(ruleId);
			conclusionDao.deleteByRuleId(ruleId);
		} catch (DBOperatorException dbe) {
			throw new RuleEngineServiceException(-110, dbe);
		}
	}

}
