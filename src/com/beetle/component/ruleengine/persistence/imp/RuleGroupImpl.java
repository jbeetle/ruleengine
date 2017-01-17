package com.beetle.component.ruleengine.persistence.imp;

import java.util.List;

import com.beetle.component.ruleengine.dto.RuleGroup;
import com.beetle.component.ruleengine.persistence.RuleGroupDao;
import com.beetle.framework.persistence.access.operator.DBOperatorException;
import com.beetle.framework.persistence.access.operator.TableOperator;

public class RuleGroupImpl implements RuleGroupDao {

	// fieldsNames:[createTime,descp,status,name,gid"]
	private TableOperator<RuleGroup> operator;

	public RuleGroupImpl() {
		operator = new TableOperator<RuleGroup>(Helper.DATASOURCE, "RuleGroup", RuleGroup.class, "gid");
		// operator = new TableOperator("SYSDATASOURCE_DEFAULT", "RuleGroup",
		//// RuleGroup.class,"IDENTITY_FIELD_NAME");
	}

	public RuleGroup get(Long id) throws DBOperatorException {
		return operator.selectByPrimaryKey(id);
	}

	public List<RuleGroup> getAll() throws DBOperatorException {
		return operator.selectByWhereCondition("", null);
	}

	public long insert(RuleGroup rulegroup) throws DBOperatorException {
		return operator.insertAndRetrievePK(rulegroup);
	}

	public int update(RuleGroup rulegroup) throws DBOperatorException {
		return operator.update(rulegroup);
	}

	public int delete(Long id) throws DBOperatorException {
		return operator.deleteByPrimaryKey(id);
	}
	
}