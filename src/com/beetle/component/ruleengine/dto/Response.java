package com.beetle.component.ruleengine.dto;

/**
 * 规则引擎执行返回的数据对象，此对象包括决策表的结论因子及其对应的值（这些值都是事先在决策表定义的）
 * 
 * @author yuhaodong@gmail.com
 *
 */
public class Response extends java.util.HashMap<String, Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean match;

	public Response() {
		super();
	}

	public void setMatch(boolean match) {
		this.match = match;
	}

	/**
	 * 是否匹配规则
	 * 
	 * @return true为匹配规则，false为不匹配规则
	 */
	public boolean isMatch() {
		return match;
	}

}
