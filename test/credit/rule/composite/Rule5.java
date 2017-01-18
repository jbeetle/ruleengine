package credit.rule.composite;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import org.slf4j.Logger;

import com.beetle.framework.log.AppLogger;

import credit.UserInfo;

@Rule(name = "LegalRule1-5", description = "")
public class Rule5 {
	private static Logger logger = AppLogger.getLogger(Rule5.class);
	private UserInfo user;

	public Rule5(UserInfo user) {
		super();
		this.user = user;
	}

	@Condition
	public boolean when() {
		// if(user.getDegree()<=2){
		// return true;
		// }
		// return false;
		return (user.getCreditNum() == 0) ? true : false;
	}

	@Action
	public void then() throws Exception {
		logger.debug("rule5 action begin");
		user.setApprove(false);
		logger.debug("user:{}",user);
		logger.debug("rule5 action end");
	}
}
