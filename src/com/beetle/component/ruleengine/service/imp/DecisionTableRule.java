package com.beetle.component.ruleengine.service.imp;

import org.easyrules.core.BasicRule;
import org.slf4j.Logger;

import com.beetle.component.ruleengine.dto.Factor;
import com.beetle.framework.AppRuntimeException;
import com.beetle.framework.log.AppLogger;

import bsh.EvalError;
import bsh.Interpreter;

public class DecisionTableRule extends BasicRule {
	private static final Logger logger = AppLogger.getLogger(DecisionTableRule.class);
	private String ruleName;
	private Factor factor;
	private Object input;

	public DecisionTableRule(String ruleName, Factor factor, Object input) {
		super(ruleName + "-" + factor.getFid());
		this.ruleName = ruleName;
		this.factor = factor;
		this.input = input;
		logger.debug("key={},value={}", factor.getVariate(), input);
	}

	@Override
	public boolean evaluate() {
		String evalString = "outputValue=" + factor.getBoolExpression();
		logger.debug("{},{} evalString:{}", ruleName, factor.getLabel(), evalString);
		Interpreter interpreter = new Interpreter();
		try {
			interpreter.set(factor.getVariate(), input);
			interpreter.eval(evalString);
			Boolean rr = (Boolean) interpreter.get("outputValue");
			logger.debug("{},{},{} evaluate result:{}", this.ruleName, factor.getFid(), factor.getVariate(), rr);
			return rr;
		} catch (EvalError e) {
			logger.error("evaluate err", e);
			throw new AppRuntimeException(-201, e);
		}
	}

	@Override
	public void execute() throws Exception {
		logger.debug("{},{},passed!", this.ruleName, factor.getVariate());
	}

}
