package credit;

import org.easyrules.api.RulesEngine;
import org.easyrules.core.CompositeRule;
import org.easyrules.core.RulesEngineBuilder;
import org.slf4j.Logger;

import com.beetle.framework.log.AppLogger;

import credit.rule.LegalRule1;
import credit.rule.LegalRule2;
import credit.rule.LegalRule3;
import credit.rule.LegalRule4;
import credit.rule.composite.Rule1;
import credit.rule.composite.Rule2;
import credit.rule.composite.Rule3;
import credit.rule.composite.Rule4;
import credit.rule.composite.Rule5;

public class CreditClient {
	private static Logger logger = AppLogger.getLogger(CreditClient.class);
	public static void main33(String[] args) {
		//RulesEngine re = RulesEngineBuilder.aNewRulesEngine().named("Credit rules engine").build();
		UserInfo user1 = new UserInfo("Henry", true, 30, 2, "13501583576", "auto", "HR", 5000, false, false, 0);
		//
		CompositeRule legalRule1 = new CompositeRule("legalRule1", "a composite rule");
		legalRule1.addRule(new Rule1(user1));
		legalRule1.addRule(new Rule2(user1));
		legalRule1.addRule(new Rule3(user1));
		legalRule1.addRule(new Rule4(user1));
		legalRule1.addRule(new Rule5(user1));
		//
		//re.registerRule(legalRule1); 
		try {
			legalRule1.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("check:{}", legalRule1.evaluate());
		//re.fireRules();
		logger.debug("done");
	}
	public static void main(String[] args) {
		RulesEngine re = RulesEngineBuilder.aNewRulesEngine().named("Credit rules engine").build();
		UserInfo user1 = new UserInfo("Henry", true, 30, 2, "13501583576", "auto", "HR", 4999, false, false, 0);
		//
		CompositeRule legalRule1 = new CompositeRule("legalRule1", "a composite rule");
		legalRule1.addRule(new Rule1(user1));
		legalRule1.addRule(new Rule2(user1));
		legalRule1.addRule(new Rule3(user1));
		legalRule1.addRule(new Rule4(user1));
		legalRule1.addRule(new Rule5(user1));
		//
		re.registerRule(legalRule1); 
		logger.debug("check:{}", re.checkRules());
		re.fireRules();
		logger.debug("done");
	}

	public static void main2(String[] args) {
		RulesEngine re = RulesEngineBuilder.aNewRulesEngine().named("Credit rules engine").build();
		UserInfo user1 = new UserInfo("Henry", true, 30, 2, "13501583576", "auto", "HR", 4999, false, false, 0);
		re.registerRule(new LegalRule1(user1));
		re.registerRule(new LegalRule2(user1));
		re.registerRule(new LegalRule3(user1));
		re.registerRule(new LegalRule4(user1));
		re.fireRules();
		logger.debug("check:{}", re.checkRules());
		logger.debug("done");
	}
}
