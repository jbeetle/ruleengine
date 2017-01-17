package com.beetle.component.ruleengine.dto;

public class Conclusion implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String variate;
	private Integer status;
	private Long ruleid;
	private String value;
	private Long cid;
	private String label;

	public Conclusion() {
	}

	public String getVariate() {
		return this.variate;
	}

	public Integer getStatus() {
		return this.status;
	}

	public Long getRuleId() {
		return this.ruleid;
	}

	public String getValue() {
		return this.value;
	}

	public Long getCId() {
		return this.cid;
	}

	public void setVariate(String variate) {
		this.variate = variate;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setRuleId(Long ruleid) {
		this.ruleid = ruleid;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setCId(Long cid) {
		this.cid = cid;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "Conclusion [variate=" + variate + ", status=" + status + ", ruleid=" + ruleid + ", value=" + value
				+ ", cid=" + cid + ", label=" + label + "]";
	}

	

}