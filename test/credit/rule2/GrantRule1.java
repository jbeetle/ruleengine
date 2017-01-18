package credit.rule2;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import org.slf4j.Logger;

import com.beetle.framework.log.AppLogger;

import credit.CreditCard;
import credit.UserInfo;

@Rule(name = "GrantRule1", description = "")
public class GrantRule1 {
	private static Logger logger = AppLogger.getLogger(GrantRule1.class);
	private UserInfo user;
	public GrantRule1(UserInfo user) {
		super();
		this.user = user;
	}
	@Condition
	public boolean when() {// 满足条件为true
		if(user.isHasHouse()==true&&user.isHasCar()==true&&user.getSalary()>20000){
			return true;
		}
		return false;
	}
	@Action(order = 1)
	public void then() throws Exception {// 条件为true时，执行的动作（通过不通过）
		user.setApprove(true);
		CreditCard card=new CreditCard();
		card.setBankName("招商银行");
		card.setValue(15000);
		user.setCreditCard(card);
		logger.debug("then:rule1 action");
		logger.debug("user:{}", user);
	}
}
