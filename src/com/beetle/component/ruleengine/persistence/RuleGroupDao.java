package com.beetle.component.ruleengine.persistence;

import java.util.List;

import com.beetle.component.ruleengine.dto.RuleGroup;
import com.beetle.framework.persistence.access.operator.DBOperatorException;

public interface RuleGroupDao {
	RuleGroup get(Long gid) throws DBOperatorException;

	List<RuleGroup> getAll() throws DBOperatorException;

	long insert(RuleGroup ruleGroup) throws DBOperatorException;

	int update(RuleGroup ruleGroup) throws DBOperatorException;

	int delete(Long gid) throws DBOperatorException;

}
