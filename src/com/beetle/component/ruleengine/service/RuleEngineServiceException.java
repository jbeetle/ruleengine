package com.beetle.component.ruleengine.service;

import com.beetle.framework.AppException;

public class RuleEngineServiceException extends AppException {
	private static final long serialVersionUID = 1L;

	public RuleEngineServiceException(int errCode, String message) {
		super(errCode, message);
	}

	public RuleEngineServiceException(int errCode, String message, Throwable cause) {
		super(errCode, message, cause);
	}

	public RuleEngineServiceException(int errCode, Throwable cause) {
		super(errCode, cause);
	}

	public RuleEngineServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public RuleEngineServiceException(String message) {
		super(message);
	}

	public RuleEngineServiceException(Throwable cause) {
		super(cause);
	}

}
