package com.beetle.component.ruleengine.persistence;

import java.util.List;

import com.beetle.component.ruleengine.dto.Factor;
import com.beetle.framework.persistence.access.operator.DBOperatorException;

public interface FactorDao {
	Factor get(Long fid) throws DBOperatorException;

	List<Factor> getByRuleId(long ruleId) throws DBOperatorException;

	int insert(Factor factor) throws DBOperatorException;

	int update(Factor factor) throws DBOperatorException;

	int delete(Long fid) throws DBOperatorException;

}
