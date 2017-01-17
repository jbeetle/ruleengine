package com.beetle.component.ruleengine.persistence.imp;

import java.util.List;

import com.beetle.component.ruleengine.dto.Factor;
import com.beetle.component.ruleengine.persistence.FactorDao;
import com.beetle.framework.persistence.access.operator.DBOperatorException;
import com.beetle.framework.persistence.access.operator.TableOperator;

public class FactorImpl implements FactorDao {

	// fieldsNames:[variate,fid,status,compare,ruleId,value"]
	private TableOperator<Factor> operator;

	public FactorImpl() {
		operator = new TableOperator<Factor>(Helper.DATASOURCE, "Factor", Factor.class, "fid");
	}

	public Factor get(Long id) throws DBOperatorException {
		return operator.selectByPrimaryKey(id);
	}

	public List<Factor> getByRuleId(long ruleId) throws DBOperatorException {
		return operator.selectByWhereCondition("where ruleId=? ", new Object[] { ruleId });
	}

	public int insert(Factor factor) throws DBOperatorException {
		return operator.insert(factor);
	}

	public int update(Factor factor) throws DBOperatorException {
		return operator.update(factor);
	}

	public int delete(Long id) throws DBOperatorException {
		return operator.deleteByPrimaryKey(id);
	}

}