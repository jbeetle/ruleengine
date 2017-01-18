package credit.rule;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import org.slf4j.Logger;

import com.beetle.framework.log.AppLogger;

import credit.UserInfo;

@Rule(name = "LegalRule2", description = "")
public class LegalRule2 {
	private static Logger logger = AppLogger.getLogger(LegalRule2.class);
	private UserInfo user;

	public LegalRule2(UserInfo user) {
		super();
		this.user = user;
	}

	@Condition
	public boolean when() {// 满足条件为true
		// 1为大专以下，2为大专,3为本科，4为本科以上
		if ((user.getDegree() == 2 || user.getDegree() == 3) && user.getSalary() < 3000 && user.isHasCar() == false
				&& user.isHasHouse() == false && user.getCreditNum() == 0) {
			logger.debug("when:true");
			return true;// 满足条件为true
		}
		logger.debug("when:false");
		return false;
	}

	@Action(order = 1)
	public void then() throws Exception {// 条件为true时，执行的动作（通过不通过）
		user.setApprove(false);
		logger.debug("then:rule2 action");
		logger.debug("user:{}", user);
	}

	@Action(order = 2)
	public void end() throws Exception {
		logger.debug("end:action");
	}
}
