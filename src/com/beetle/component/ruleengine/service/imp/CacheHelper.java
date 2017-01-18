package com.beetle.component.ruleengine.service.imp;

import com.beetle.framework.AppProperties;
import com.beetle.framework.util.cache.ICache;
import com.beetle.framework.util.cache.TimeOutCache;

public class CacheHelper {
	private static ICache GROUPCACHE = null;
	private static boolean cacheFlag = false;

	static {
		int x = AppProperties.getAsInt("ruleEngine_queryRuleGroupCacheTime", 30);
		if (x > 0) {
			GROUPCACHE = new TimeOutCache(x * 1000);
			cacheFlag = true;
		}
	}

	public static ICache getGROUPCACHE() {
		return GROUPCACHE;
	}

	public static boolean isCacheFlag() {
		return cacheFlag;
	}
	
}
