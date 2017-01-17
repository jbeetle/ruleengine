package com.beetle.component.ruleengine.dto;

import java.util.ArrayList;
import java.util.List;

public class Rule implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private java.sql.Timestamp createtime;
	private String descp;
	private Integer status;
	private String name;
	private Long ruleid;
	private Long gid;
	private Integer exeOrder;
	private List<Conclusion> conclusionList = new ArrayList<>();
	private List<Factor> factorList = new ArrayList<>();

	public Rule() {
	}

	public List<Conclusion> getConclusionList() {
		return conclusionList;
	}

	public void addConclusion(Conclusion conclusion) {
		this.conclusionList.add(conclusion);
	}

	public List<Factor> getFactorList() {
		return factorList;
	}

	public void addFactor(Factor factor) {
		this.factorList.add(factor);
	}

	public java.sql.Timestamp getCreateTime() {
		return this.createtime;
	}

	public String getDescp() {
		return this.descp;
	}

	public Integer getStatus() {
		return this.status;
	}

	public String getName() {
		return this.name;
	}

	public Long getRuleId() {
		return this.ruleid;
	}

	public Long getGid() {
		return this.gid;
	}

	public void setCreateTime(java.sql.Timestamp createtime) {
		this.createtime = createtime;
	}

	public void setDescp(String descp) {
		this.descp = descp;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRuleId(Long ruleid) {
		this.ruleid = ruleid;
	}

	public void setGid(Long gid) {
		this.gid = gid;
	}

	public Integer getExeOrder() {
		return exeOrder;
	}

	public void setExeOrder(Integer exeOrder) {
		this.exeOrder = exeOrder;
	}

	@Override
	public String toString() {
		return "Rule [createtime=" + createtime + ", descp=" + descp + ", status=" + status + ", name=" + name
				+ ", ruleid=" + ruleid + ", gid=" + gid + ", exeOrder=" + exeOrder + ", conclusionList="
				+ conclusionList + ", factorList=" + factorList + "]";
	}

	
}