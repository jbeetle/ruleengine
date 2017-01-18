package credit.rule;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import org.slf4j.Logger;

import com.beetle.framework.log.AppLogger;

import credit.UserInfo;

@Rule(name = "LegalRule4", description = "")
public class LegalRule4 {
	private static Logger logger = AppLogger.getLogger(LegalRule4.class);
	private UserInfo user;

	public LegalRule4(UserInfo user) {
		super();
		this.user = user;
	}

	@Condition
	public boolean when() {// 满足条件为true
		if (user.getCreditNum() > 10) {
			logger.debug("when:true");
			return true;// 满足条件为true
		}
		logger.debug("when:false");
		return false;
	}

	@Action(order = 1)
	public void then() throws Exception {// 条件为true时，执行的动作（通过不通过）
		user.setApprove(false);
		logger.debug("then:rule4 action");
		logger.debug("user:{}", user);
	}

	@Action(order = 2)
	public void end() throws Exception {
		logger.debug("end:action");
	}
}
