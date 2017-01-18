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

public class CreditCheck {
	public static void main(String[] args) {
		DecisionTableService dts = DIContainer.getInstance().retrieve(DecisionTableService.class);
		try {
			//mainCreate(args);
		//// 1为大专以下，2为大专,3为本科，4为本科以上
			Request request = new Request(1);
			request.put("xinshui", 2999); 
			request.put("xieli", 2);
			request.put("chezi", 0);
			request.put("fangzi", 0);
			request.put("xinyonka", 0);
			Response reponse = dts.execute(request);
			System.out.println(reponse.isMatch());
			System.out.println(reponse);
		} catch (RuleEngineServiceException e) {
			e.printStackTrace();
		}
	}

	public static void main33(String[] args) {
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
		rg.setDescp("用户申请信用卡合法性检测，适配规则的则为不通过");
		rg.setName("用户合法性校验");
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
		try {
			dts.createRuleGroup(rg);
		} catch (RuleEngineServiceException e) {
			e.printStackTrace();
		}
	}

	private static void setRule2(RuleGroup rg, Rule rule1) {
		rule1.setCreateTime(rg.getCreateTime());
		rule1.setDescp("针对大专学历的");
		rule1.setName("rule2");
		rule1.setStatus(1);
		rule1.setExeOrder(2);
		Factor f1 = new Factor();
		f1.setLabel("学历");
		f1.setVariate("xieli");
		// f1.setCompare(CompareFlag.XiaoYuDengYu.getValue());
		f1.setBoolExpression("(xieli==2)");
		//// 1为大专以下，2为大专,3为本科，4为本科以上
		f1.setStatus(1);
		rule1.addFactor(f1);
		Factor f2 = new Factor();
		f2.setLabel("薪水");
		f2.setVariate("xinshui");
		f2.setBoolExpression("(xinshui<3000)");
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
		Factor f5 = new Factor();
		f5.setLabel("信用卡数量");
		f5.setVariate("xinyonka");
		f5.setBoolExpression("(xinyonka==0)");
		f5.setStatus(1);
		rule1.addFactor(f5);
		Conclusion conclusion = new Conclusion();
		conclusion.setLabel("是否通过");
		conclusion.setVariate("passFlag");
		conclusion.setValue("false");
		// conclusion.setValueType(0);
		conclusion.setStatus(1);
		rule1.addConclusion(conclusion);
	}

	private static void setRule3(RuleGroup rg, Rule rule1) {
		rule1.setCreateTime(rg.getCreateTime());
		rule1.setDescp("针对本科学历的");
		rule1.setName("rule3");
		rule1.setStatus(1);
		rule1.setExeOrder(3);
		Factor f1 = new Factor();
		f1.setLabel("学历");
		f1.setVariate("xieli");
		// f1.setCompare(CompareFlag.XiaoYuDengYu.getValue());
		f1.setBoolExpression("(xieli==3)");
		//// 1为大专以下，2为大专,3为本科，4为本科以上
		f1.setStatus(1);
		rule1.addFactor(f1);
		Factor f2 = new Factor();
		f2.setLabel("薪水");
		f2.setVariate("xinshui");
		f2.setBoolExpression("(xinshui<3000)");
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
		Factor f5 = new Factor();
		f5.setLabel("信用卡数量");
		f5.setVariate("xinyonka");
		f5.setBoolExpression("(xinyonka==0)");
		f5.setStatus(1);
		rule1.addFactor(f5);
		Conclusion conclusion = new Conclusion();
		conclusion.setLabel("是否通过");
		conclusion.setVariate("passFlag");
		conclusion.setValue("false");
		// conclusion.setValueType(0);
		conclusion.setStatus(1);
		rule1.addConclusion(conclusion);
	}

	private static void setRule4(RuleGroup rg, Rule rule1) {
		rule1.setCreateTime(rg.getCreateTime());
		rule1.setDescp("针对高学历的");
		rule1.setName("rule4");
		rule1.setStatus(1);
		rule1.setExeOrder(4);
		Factor f1 = new Factor();
		f1.setLabel("学历");
		f1.setVariate("xieli");
		// f1.setCompare(CompareFlag.XiaoYuDengYu.getValue());
		f1.setBoolExpression("(xieli>3)");
		//// 1为大专以下，2为大专,3为本科，4为本科以上
		f1.setStatus(1);
		rule1.addFactor(f1);
		Factor f2 = new Factor();
		f2.setLabel("薪水");
		f2.setVariate("xinshui");
		f2.setBoolExpression("(xinshui<2000)");
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
		Factor f5 = new Factor();
		f5.setLabel("信用卡数量");
		f5.setVariate("xinyonka");
		f5.setBoolExpression("(xinyonka==0)");
		f5.setStatus(1);
		rule1.addFactor(f5);
		Conclusion conclusion = new Conclusion();
		conclusion.setLabel("是否通过");
		conclusion.setVariate("passFlag");
		conclusion.setValue("false");
		// conclusion.setValueType(0);
		conclusion.setStatus(1);
		rule1.addConclusion(conclusion);
	}

	private static void setRule1(RuleGroup rg, Rule rule1) {
		rule1.setCreateTime(rg.getCreateTime());
		rule1.setDescp("针对低学历的");
		rule1.setName("rule1");
		rule1.setStatus(1);
		rule1.setExeOrder(1);
		Factor f1 = new Factor();
		f1.setLabel("学历");
		f1.setVariate("xieli");
		// f1.setCompare(CompareFlag.XiaoYuDengYu.getValue());
		f1.setBoolExpression("(xieli<2)");
		//// 1为大专以下，2为大专,3为本科，4为本科以上
		f1.setStatus(1);
		rule1.addFactor(f1);
		Factor f2 = new Factor();
		f2.setLabel("薪水");
		f2.setVariate("xinshui");
		f2.setBoolExpression("(xinshui<5000)");
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
		Factor f5 = new Factor();
		f5.setLabel("信用卡数量");
		f5.setVariate("xinyonka");
		f5.setBoolExpression("(xinyonka==0)");
		f5.setStatus(1);
		rule1.addFactor(f5);
		Conclusion conclusion = new Conclusion();
		conclusion.setLabel("是否通过");
		conclusion.setVariate("passFlag");
		conclusion.setValue("false");
		// conclusion.setValueType(0);
		conclusion.setStatus(1);
		rule1.addConclusion(conclusion);
	}

	private static void setRule5(RuleGroup rg, Rule rule1) {
		rule1.setCreateTime(rg.getCreateTime());
		rule1.setDescp("针对已有信用卡用户");
		rule1.setName("rule5");
		rule1.setStatus(1);
		rule1.setExeOrder(5);
		Factor f1 = new Factor();
		f1.setLabel("学历");
		f1.setVariate("xieli");
		// f1.setCompare(CompareFlag.XiaoYuDengYu.getValue());
		f1.setBoolExpression("/");
		//// 1为大专以下，2为大专,3为本科，4为本科以上
		f1.setStatus(0);
		rule1.addFactor(f1);
		Factor f2 = new Factor();
		f2.setLabel("薪水");
		f2.setVariate("xinshui");
		f2.setBoolExpression("/");
		f2.setStatus(0);
		rule1.addFactor(f2);
		Factor f3 = new Factor();
		f3.setLabel("车子");
		f3.setVariate("chezi");
		f3.setBoolExpression("/");
		f3.setStatus(0);
		rule1.addFactor(f3);
		Factor f4 = new Factor();
		f4.setLabel("房子");
		f4.setVariate("fangzi");
		f4.setBoolExpression("/");
		f4.setStatus(0);
		rule1.addFactor(f4);
		Factor f5 = new Factor();
		f5.setLabel("信用卡数量");
		f5.setVariate("xinyonka");
		f5.setBoolExpression("(xinyonka>10)");
		f5.setStatus(1);
		rule1.addFactor(f5);
		Conclusion conclusion = new Conclusion();
		conclusion.setLabel("是否通过");
		conclusion.setVariate("passFlag");
		conclusion.setValue("false");
		// conclusion.setValueType(0);
		conclusion.setStatus(1);
		rule1.addConclusion(conclusion);
	}

}
