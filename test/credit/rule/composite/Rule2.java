package credit.rule.composite;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import org.slf4j.Logger;

import com.beetle.framework.log.AppLogger;

import credit.UserInfo;

@Rule(name = "LegalRule1-2", description = "")
public class Rule2 {
	private static Logger logger = AppLogger.getLogger(Rule2.class);
	private UserInfo user;

	public Rule2(UserInfo user) {
		super();
		this.user = user;
	}

	@Condition
	public boolean when() {
		// if(user.getDegree()<=2){
		// return true;
		// }
		// return false;
		return (user.getSalary() < 5000) ? true : false;
	}

	@Action
	public void then() throws Exception {
		logger.debug("rule2 action");
	}
}
