package com.beetle.component.ruleengine.service;

import com.beetle.component.ruleengine.dto.Request;
import com.beetle.component.ruleengine.dto.Response;
import com.beetle.component.ruleengine.dto.Rule;
import com.beetle.component.ruleengine.dto.RuleGroup;

/**
 * 决策表服务
 * 
 * @author yuhaodong@gmail.com
 *
 */
public interface DecisionTableService {
	/**
	 * 创建一个决策表
	 * 
	 * @param ruleGroup
	 * @throws RuleEngineServiceException
	 */
	void createRuleGroup(RuleGroup ruleGroup) throws RuleEngineServiceException;

	void deleteRuleGroup(long ruleGroupId) throws RuleEngineServiceException;

	void createRuleToRuleGroup(Rule rule) throws RuleEngineServiceException;

	void deleteRuleFromRuleGroup(long ruleId) throws RuleEngineServiceException;

	/**
	 * 根据ruleGroupId获取到整个规则组的信息
	 * 
	 * @param ruleGroupId
	 * @return
	 * @throws RuleEngineServiceException
	 */
	RuleGroup queryRuleGroup(long ruleGroupId) throws RuleEngineServiceException;

	/**
	 * 执行，运算决策表，并返回匹配的结果
	 * 
	 * @param request
	 * @return
	 * @throws RuleEngineServiceException
	 */
	Response execute(Request request) throws RuleEngineServiceException;
}
