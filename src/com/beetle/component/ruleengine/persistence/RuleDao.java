package com.beetle.component.ruleengine.persistence;

import java.util.List;

import com.beetle.component.ruleengine.dto.Rule;
import com.beetle.framework.persistence.access.operator.DBOperatorException;

public interface RuleDao {
	Rule get(Long ruleid) throws DBOperatorException;

	List<Rule> getRulesByGroupId(long ruleGroupId) throws DBOperatorException;

	long insert(Rule rule) throws DBOperatorException;

	int update(Rule rule) throws DBOperatorException;

	int delete(Long ruleid) throws DBOperatorException;

}
