package com.beetle.component.ruleengine.persistence.imp;

import java.util.List;

import com.beetle.component.ruleengine.dto.Conclusion;
import com.beetle.component.ruleengine.persistence.ConclusionDao;
import com.beetle.framework.persistence.access.operator.DBOperatorException;
import com.beetle.framework.persistence.access.operator.TableOperator;

public class ConclusionImpl implements ConclusionDao {

	// fieldsNames:[variate,status,ruleId,action,value,cId"]
	private TableOperator<Conclusion> operator;

	public ConclusionImpl() {
		operator = new TableOperator<Conclusion>(Helper.DATASOURCE, "Conclusion", Conclusion.class, "cId");
	}

	public Conclusion get(Long id) throws DBOperatorException {
		return operator.selectByPrimaryKey(id);
	}

	public List<Conclusion> getByRuleId(long ruleId) throws DBOperatorException {
		return operator.selectByWhereCondition("where ruleId=? ", new Object[] { ruleId });
	}

	public int insert(Conclusion conclusion) throws DBOperatorException {
		return operator.insert(conclusion);
	}

	public int update(Conclusion conclusion) throws DBOperatorException {
		return operator.update(conclusion);
	}

	public int delete(Long id) throws DBOperatorException {
		return operator.deleteByPrimaryKey(id);
	}

}