package com.beetle.component.ruleengine.dto;
/**
 * 规则数据输入请求对象<br>
 * 输入数据采取Key-Value的方式，Key是条件因子的名称，value-为次条件因子要匹配（检验）的值
 * @author yuhaodong@gmail.com
 *
 */
public class Request extends java.util.HashMap<String, Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long ruleGroupId;

	public Request(long ruleGroupId) {
		super();
		this.ruleGroupId = ruleGroupId;
	}

	public long getRuleGroupId() {
		return ruleGroupId;
	}

}
