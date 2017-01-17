package com.beetle.component.ruleengine.persistence;

import java.util.List;

import com.beetle.component.ruleengine.dto.Conclusion;
import com.beetle.framework.persistence.access.operator.DBOperatorException;

public interface ConclusionDao {
	Conclusion get(Long cid) throws DBOperatorException;

	List<Conclusion> getByRuleId(long ruleId) throws DBOperatorException;

	int insert(Conclusion conclusion) throws DBOperatorException;

	int update(Conclusion conclusion) throws DBOperatorException;

	int delete(Long cid) throws DBOperatorException;

}
