package com.beetle.component.ruleengine.persistence.imp;

import com.beetle.framework.AppProperties;

public class Helper {
	public static String DATASOURCE = "";
	static {
		DATASOURCE = AppProperties.get("ruleEngine_datasource", "SYSDATASOURCE_DEFAULT");
	}

}
