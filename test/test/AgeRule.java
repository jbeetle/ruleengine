package test;

import org.easyrules.core.BasicRule;

public class AgeRule extends BasicRule {
	private static final int ADULT_AGE = 18;

	private Person person;

	public AgeRule(Person person) {
		super("AgeRule", "Check if person's age is > 18 and" + "marks the person as adult", 1);
		this.person = person;
	}

	@Override
	public boolean evaluate() {
		return person.getAge() > ADULT_AGE;
	}

	@Override
	public void execute() throws Exception {
		person.setAdult(true);
		System.out.printf("Person %s has been marked as adult", person.getName());
	}

}
