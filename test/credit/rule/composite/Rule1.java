package credit.rule.composite;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import org.slf4j.Logger;

import com.beetle.framework.log.AppLogger;

import credit.UserInfo;

@Rule(name = "LegalRule1-1", description = "")
public class Rule1 {
	private static Logger logger = AppLogger.getLogger(Rule1.class);
	private UserInfo user;

	public Rule1(UserInfo user) {
		super();
		this.user = user;
	}

	@Condition
	public boolean when() {
		// if(user.getDegree()<=2){
		// return true;
		// }
		// return false;
		return (user.getDegree() <= 2) ? true : false;
	}

	@Action
	public void then() throws Exception {
		logger.debug("rule1 action");
	}
}
