package test;

import java.util.Scanner;

import org.easyrules.api.RulesEngine;
import org.easyrules.core.RulesEngineBuilder;

public class Client {
	public static void main(String[] args) {
		Person tom = new Person("Tom", 14);
        System.out.println("Tom:Hi! can I have some Vodka please?");
                

        //create a rules engine
        RulesEngine rulesEngine = RulesEngineBuilder.aNewRulesEngine()
                .named("shop rules engine")
                .build();
        //register rules
        rulesEngine.registerRule(new AgeRule(tom));
        rulesEngine.registerRule(new AlcoholRule(tom));

        //fire rules
        rulesEngine.fireRules();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Change adult age ");
        String xxx=scanner.nextLine().trim();

        tom.setAge(Integer.parseInt(xxx));
        //rulesEngine.clearRules();
        
        rulesEngine.fireRules();
	}
	public static void main1(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Are you a friend of duke?[yes/no]:");
		String input = scanner.nextLine();

		/**
		 * Declare the rule
		 */
		HelloWorldRule helloWorldRule = new HelloWorldRule();

		/**
		 * Set business data to operate on
		 */
		helloWorldRule.setInput(input.trim());

		/**
		 * Create a rules engine and register the business rule
		 */
		RulesEngine rulesEngine = RulesEngineBuilder.aNewRulesEngine().build();

		rulesEngine.registerRule(helloWorldRule);

		/**
		 * Fire rules
		 */
		rulesEngine.fireRules();

	}

}
