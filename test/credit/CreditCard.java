package credit;

import java.io.Serializable;

public class CreditCard implements Serializable {

	private static final long serialVersionUID = 1L;
	private String bankName;// 发卡行
	private int value;// 信用额度
	private String remark;// 备注
	private UserInfo userInfo;// 所属用户

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
