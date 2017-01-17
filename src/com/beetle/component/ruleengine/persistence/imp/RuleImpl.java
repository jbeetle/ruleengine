package com.beetle.component.ruleengine.persistence.imp;

import java.util.List;

import com.beetle.component.ruleengine.dto.Rule;
import com.beetle.component.ruleengine.persistence.RuleDao;
import com.beetle.framework.persistence.access.operator.DBOperatorException;
import com.beetle.framework.persistence.access.operator.TableOperator;

public class RuleImpl implements RuleDao {

	// fieldsNames:[createTime,descp,status,name,ruleId,gid"]
	private TableOperator<Rule> operator;

	public RuleImpl() {
		// operator = new TableOperator<Rule>(Helper.DATASOURCE, "Rule",
		// Rule.class);
		operator = new TableOperator<Rule>(Helper.DATASOURCE, "Rule", Rule.class, "ruleId");
	}

	public Rule get(Long id) throws DBOperatorException {
		return operator.selectByPrimaryKey(id);
	}

	public List<Rule> getRulesByGroupId(long ruleGroupId) throws DBOperatorException {
		return operator.selectByWhereCondition("where gid=? order by exeOrder asc", new Object[] { ruleGroupId });
	}

	public long insert(Rule rule) throws DBOperatorException {
		return operator.insertAndRetrievePK(rule);
	}

	public int update(Rule rule) throws DBOperatorException {
		return operator.update(rule);
	}

	public int delete(Long id) throws DBOperatorException {
		return operator.deleteByPrimaryKey(id);
	}

}