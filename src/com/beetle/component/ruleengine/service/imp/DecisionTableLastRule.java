package com.beetle.component.ruleengine.service.imp;

import java.util.List;

import org.easyrules.core.BasicRule;
import org.slf4j.Logger;

import com.beetle.component.ruleengine.dto.Conclusion;
import com.beetle.component.ruleengine.dto.Response;
import com.beetle.framework.log.AppLogger;

public class DecisionTableLastRule extends BasicRule {
	private static final Logger logger = AppLogger.getLogger(DecisionTableLastRule.class);

	private String ruleName;
	private Long ruleId;
	private List<Conclusion> conclusions;
	private Response response;

	public DecisionTableLastRule(String ruleName, Long ruleId, List<Conclusion> conclusions, Response response) {
		super();
		this.ruleName = ruleName;
		this.ruleId = ruleId;
		this.conclusions = conclusions;
		this.response = response;
	}

	@Override
	public boolean evaluate() {
		return true;
	}

	@Override
	public void execute() throws Exception {
		response.setMatch(true);
		response.put("ruleId", ruleId);
		response.put("ruleName", ruleName);
		for (Conclusion c : conclusions) {
			response.put(c.getVariate(), c.getValue());
		}
		logger.debug("{} execute", ruleName);
		logger.debug("reponse:{}", response);
	}

}
