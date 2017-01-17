package com.beetle.component.ruleengine.dto;

import java.util.ArrayList;
import java.util.List;

public class RuleGroup implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private java.sql.Timestamp createtime;
	private String descp;
	private Integer status;
	private String name;
	private Long gid;
	private List<Rule> ruleList = new ArrayList<>();

	public RuleGroup() {
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

	public void setGid(Long gid) {
		this.gid = gid;
	}

	public List<Rule> getRuleList() {
		return ruleList;
	}

	public void addRule(Rule rule) {
		this.ruleList.add(rule);
	}

	@Override
	public String toString() {
		return "RuleGroup [createtime=" + createtime + ", descp=" + descp + ", status=" + status + ", name=" + name
				+ ", gid=" + gid + ", ruleList=" + ruleList + "]";
	}

}