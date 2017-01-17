package com.beetle.component.ruleengine.dto;

public class Factor implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String variate;
	private Long fid;
	private Integer status;
	private String boolExpression;
	private Long ruleid;
	private String label;

	public Factor() {
	}

	public String getVariate() {
		return this.variate;
	}

	public Long getFid() {
		return this.fid;
	}

	public Integer getStatus() {
		return this.status;
	}

	public Long getRuleId() {
		return this.ruleid;
	}

	public void setVariate(String variate) {
		this.variate = variate;
	}

	public void setFid(Long fid) {
		this.fid = fid;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setRuleId(Long ruleid) {
		this.ruleid = ruleid;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getBoolExpression() {
		return boolExpression;
	}

	public void setBoolExpression(String boolExpression) {
		this.boolExpression = boolExpression;
	}

	@Override
	public String toString() {
		return "Factor [variate=" + variate + ", fid=" + fid + ", status=" + status + ", boolExpression="
				+ boolExpression + ", ruleid=" + ruleid + ", label=" + label + "]";
	}

}