package test;

import java.sql.Timestamp;

import com.beetle.component.ruleengine.dto.Conclusion;
import com.beetle.component.ruleengine.dto.Factor;
import com.beetle.component.ruleengine.dto.Request;
import com.beetle.component.ruleengine.dto.Response;
import com.beetle.component.ruleengine.dto.Rule;
import com.beetle.component.ruleengine.dto.RuleGroup;
import com.beetle.component.ruleengine.service.DecisionTableService;
import com.beetle.component.ruleengine.service.RuleEngineServiceException;
import com.beetle.framework.resource.dic.DIContainer;

public class CreditPay {
	public static void main(String[] args) throws Throwable {
		DecisionTableService dts = DIContainer.getInstance().retrieve(DecisionTableService.class);
		try {
			Request request = new Request(2);
			request.put("xinshui", 21000);
			request.put("chezi", 1);
			request.put("fangzi", 2);
			Response reponse = dts.execute(request);
			System.out.println(reponse.isMatch());
			System.out.println(reponse);
		} catch (RuleEngineServiceException e) {
			e.printStackTrace();
		}
	}

	public static void main222(String[] args) throws Throwable {
		Rule rule1 = new Rule();
		rule1.setGid(2l);
		rule1.setCreateTime(new Timestamp(System.currentTimeMillis()));
		rule1.setDescp("针对有房有车的中等收入人群");
		rule1.setName("rule8");
		rule1.setStatus(1);
		rule1.setExeOrder(8);
		Factor f2 = new Factor();
		f2.setLabel("薪水");
		f2.setVariate("xinshui");
		f2.setBoolExpression("(xinshui>=10000 && xinshui<=20000)");
		f2.setStatus(1);
		rule1.addFactor(f2);
		Factor f3 = new Factor();
		f3.setLabel("车子");
		f3.setVariate("chezi");
		f3.setBoolExpression("(chezi>=1)");
		f3.setStatus(1);
		rule1.addFactor(f3);
		Factor f4 = new Factor();
		f4.setLabel("房子");
		f4.setVariate("fangzi");
		f4.setBoolExpression("(fangzi>=1)");
		f4.setStatus(1);
		rule1.addFactor(f4);
		Conclusion conclusion = new Conclusion();
		conclusion.setLabel("发放额度");
		conclusion.setVariate("ceiling");
		conclusion.setValue("9000");
		// conclusion.setValueType(0);
		conclusion.setStatus(1);
		rule1.addConclusion(conclusion);
		DecisionTableService dts = DIContainer.getInstance().retrieve(DecisionTableService.class);
		dts.createRuleToRuleGroup(rule1);
	}

	public static void mainxx(String[] args) throws Throwable {
		DecisionTableService dts = DIContainer.getInstance().retrieve(DecisionTableService.class);
		call(dts);
		for (int i = 0; i < 50; i++) {
			System.out.println("=========================" + i);
			Thread.sleep(15 * 1000);
			call(dts);
		}
	}

	private static void call(DecisionTableService dts) {
		try {
			// mainCreate(args);
			Request request = new Request(2);
			request.put("xinshui", 14000);
			request.put("chezi", 1);
			request.put("fangzi", 2);
			Response reponse = dts.execute(request);
			System.out.println(reponse);
		} catch (RuleEngineServiceException e) {
			e.printStackTrace();
		}
	}

	public static void main1(String[] args) {
		DecisionTableService dts = DIContainer.getInstance().retrieve(DecisionTableService.class);
		try {
			RuleGroup rg = dts.queryRuleGroup(1);
			System.out.println(rg);
		} catch (RuleEngineServiceException e) {
			e.printStackTrace();
		}
	}

	public static void mainCreate(String[] args) {
		DecisionTableService dts = DIContainer.getInstance().retrieve(DecisionTableService.class);
		RuleGroup rg = new RuleGroup();
		rg.setCreateTime(new Timestamp(System.currentTimeMillis()));
		rg.setDescp("通过的用户发放的信用额度");
		rg.setName("用户信用卡发放规则");
		rg.setStatus(1);
		Rule rule1 = new Rule();
		setRule1(rg, rule1);
		rg.addRule(rule1);
		Rule rule2 = new Rule();
		setRule2(rg, rule2);
		rg.addRule(rule2);
		Rule rule3 = new Rule();
		setRule3(rg, rule3);
		rg.addRule(rule3);
		Rule rule4 = new Rule();
		setRule4(rg, rule4);
		rg.addRule(rule4);
		Rule rule5 = new Rule();
		setRule5(rg, rule5);
		rg.addRule(rule5);
		Rule rule6 = new Rule();
		setRule6(rg, rule6);
		rg.addRule(rule6);
		Rule rule7 = new Rule();
		setRule7(rg, rule7);
		rg.addRule(rule7);
		try {
			dts.createRuleGroup(rg);
		} catch (RuleEngineServiceException e) {
			e.printStackTrace();
		}
	}

	private static void setRule2(RuleGroup rg, Rule rule1) {
		rule1.setCreateTime(rg.getCreateTime());
		rule1.setDescp("针对中等收入人群");
		rule1.setName("rule2");
		rule1.setStatus(1);
		rule1.setExeOrder(2);
		Factor f2 = new Factor();
		f2.setLabel("薪水");
		f2.setVariate("xinshui");
		f2.setBoolExpression("(xinshui>=10000 && xinshui<=20000)");
		f2.setStatus(1);
		rule1.addFactor(f2);
		Factor f3 = new Factor();
		f3.setLabel("车子");
		f3.setVariate("chezi");
		f3.setBoolExpression("(chezi==0)");
		f3.setStatus(1);
		rule1.addFactor(f3);
		Factor f4 = new Factor();
		f4.setLabel("房子");
		f4.setVariate("fangzi");
		f4.setBoolExpression("(fangzi==0)");
		f4.setStatus(1);
		rule1.addFactor(f4);
		Conclusion conclusion = new Conclusion();
		conclusion.setLabel("发放额度");
		conclusion.setVariate("ceiling");
		conclusion.setValue("6000");
		conclusion.setStatus(1);
		rule1.addConclusion(conclusion);
	}

	private static void setRule3(RuleGroup rg, Rule rule1) {
		rule1.setCreateTime(rg.getCreateTime());
		rule1.setDescp("针对低收入人群");
		rule1.setName("rule3");
		rule1.setStatus(1);
		rule1.setExeOrder(3);
		Factor f2 = new Factor();
		f2.setLabel("薪水");
		f2.setVariate("xinshui");
		f2.setBoolExpression("(xinshui<10000)");
		f2.setStatus(1);
		rule1.addFactor(f2);
		Factor f3 = new Factor();
		f3.setLabel("车子");
		f3.setVariate("chezi");
		f3.setBoolExpression("(chezi==0)");
		f3.setStatus(1);
		rule1.addFactor(f3);
		Factor f4 = new Factor();
		f4.setLabel("房子");
		f4.setVariate("fangzi");
		f4.setBoolExpression("(fangzi==0)");
		f4.setStatus(1);
		rule1.addFactor(f4);
		Conclusion conclusion = new Conclusion();
		conclusion.setLabel("发放额度");
		conclusion.setVariate("ceiling");
		conclusion.setValue("3000");
		conclusion.setStatus(1);
		rule1.addConclusion(conclusion);
	}

	private static void setRule4(RuleGroup rg, Rule rule1) {
		rule1.setCreateTime(rg.getCreateTime());
		rule1.setDescp("针对有房人群");
		rule1.setName("rule4");
		rule1.setStatus(1);
		rule1.setExeOrder(4);
		Factor f2 = new Factor();
		f2.setLabel("薪水");
		f2.setVariate("xinshui");
		f2.setBoolExpression("(xinshui<10000)");
		f2.setStatus(1);
		rule1.addFactor(f2);
		Factor f3 = new Factor();
		f3.setLabel("车子");
		f3.setVariate("chezi");
		f3.setBoolExpression("(chezi==0)");
		f3.setStatus(1);
		rule1.addFactor(f3);
		Factor f4 = new Factor();
		f4.setLabel("房子");
		f4.setVariate("fangzi");
		f4.setBoolExpression("(fangzi>=1)");
		f4.setStatus(1);
		rule1.addFactor(f4);
		Conclusion conclusion = new Conclusion();
		conclusion.setLabel("发放额度");
		conclusion.setVariate("ceiling");
		conclusion.setValue("5000");
		conclusion.setStatus(1);
		rule1.addConclusion(conclusion);
	}

	private static void setRule1(RuleGroup rg, Rule rule1) {
		rule1.setCreateTime(rg.getCreateTime());
		rule1.setDescp("针对高收入人群");
		rule1.setName("rule1");
		rule1.setStatus(1);
		rule1.setExeOrder(1);
		Factor f2 = new Factor();
		f2.setLabel("薪水");
		f2.setVariate("xinshui");
		f2.setBoolExpression("(xinshui>20000)");
		f2.setStatus(1);
		rule1.addFactor(f2);
		Factor f3 = new Factor();
		f3.setLabel("车子");
		f3.setVariate("chezi");
		f3.setBoolExpression("(chezi>=1)");
		f3.setStatus(1);
		rule1.addFactor(f3);
		Factor f4 = new Factor();
		f4.setLabel("房子");
		f4.setVariate("fangzi");
		f4.setBoolExpression("(fangzi>=1)");
		f4.setStatus(1);
		rule1.addFactor(f4);
		Conclusion conclusion = new Conclusion();
		conclusion.setLabel("发放额度");
		conclusion.setVariate("ceiling");
		conclusion.setValue("15000");
		// conclusion.setValueType(0);
		conclusion.setStatus(1);
		rule1.addConclusion(conclusion);
	}

	private static void setRule5(RuleGroup rg, Rule rule1) {
		rule1.setCreateTime(rg.getCreateTime());
		rule1.setDescp("针对有车人群");
		rule1.setName("rule5");
		rule1.setStatus(1);
		rule1.setExeOrder(5);
		Factor f2 = new Factor();
		f2.setLabel("薪水");
		f2.setVariate("xinshui");
		f2.setBoolExpression("(xinshui<10000)");
		f2.setStatus(1);
		rule1.addFactor(f2);
		Factor f3 = new Factor();
		f3.setLabel("车子");
		f3.setVariate("chezi");
		f3.setBoolExpression("(chezi>=1)");
		f3.setStatus(1);
		rule1.addFactor(f3);
		Factor f4 = new Factor();
		f4.setLabel("房子");
		f4.setVariate("fangzi");
		f4.setBoolExpression("(fangzi==0)");
		f4.setStatus(1);
		rule1.addFactor(f4);
		Conclusion conclusion = new Conclusion();
		conclusion.setLabel("发放额度");
		conclusion.setVariate("ceiling");
		conclusion.setValue("5000");
		conclusion.setStatus(1);
		rule1.addConclusion(conclusion);
	}

	private static void setRule6(RuleGroup rg, Rule rule1) {
		rule1.setCreateTime(rg.getCreateTime());
		rule1.setDescp("针对有房中等收入人群");
		rule1.setName("rule6");
		rule1.setStatus(1);
		rule1.setExeOrder(6);
		Factor f2 = new Factor();
		f2.setLabel("薪水");
		f2.setVariate("xinshui");
		f2.setBoolExpression("(xinshui>=10000 && xinshui<=20000)");
		f2.setStatus(1);
		rule1.addFactor(f2);
		Factor f3 = new Factor();
		f3.setLabel("车子");
		f3.setVariate("chezi");
		f3.setBoolExpression("(chezi==0)");
		f3.setStatus(1);
		rule1.addFactor(f3);
		Factor f4 = new Factor();
		f4.setLabel("房子");
		f4.setVariate("fangzi");
		f4.setBoolExpression("(fangzi>=1)");
		f4.setStatus(1);
		rule1.addFactor(f4);
		Conclusion conclusion = new Conclusion();
		conclusion.setLabel("发放额度");
		conclusion.setVariate("ceiling");
		conclusion.setValue("8000");
		conclusion.setStatus(1);
		rule1.addConclusion(conclusion);
	}

	private static void setRule7(RuleGroup rg, Rule rule1) {
		rule1.setCreateTime(rg.getCreateTime());
		rule1.setDescp("针对有车中等收入人群");
		rule1.setName("rule7");
		rule1.setStatus(1);
		rule1.setExeOrder(7);
		Factor f2 = new Factor();
		f2.setLabel("薪水");
		f2.setVariate("xinshui");
		f2.setBoolExpression("(xinshui>=10000 && xinshui<=20000)");
		f2.setStatus(1);
		rule1.addFactor(f2);
		Factor f3 = new Factor();
		f3.setLabel("车子");
		f3.setVariate("chezi");
		f3.setBoolExpression("(chezi>=1)");
		f3.setStatus(1);
		rule1.addFactor(f3);
		Factor f4 = new Factor();
		f4.setLabel("房子");
		f4.setVariate("fangzi");
		f4.setBoolExpression("(fangzi==0)");
		f4.setStatus(1);
		rule1.addFactor(f4);
		Conclusion conclusion = new Conclusion();
		conclusion.setLabel("发放额度");
		conclusion.setVariate("ceiling");
		conclusion.setValue("8000");
		conclusion.setStatus(1);
		rule1.addConclusion(conclusion);
	}
}
