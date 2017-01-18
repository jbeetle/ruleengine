package credit;

import java.io.Serializable;

public class UserInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String username;
	private boolean sex;
	private int age;
	private int degree;// 1为大专以下，2为大专,3为本科，4为本科以上
	private String phone;
	private String company;
	private String title;
	private int salary;

	private boolean hasHouse;
	private boolean hasCar;
	private int CreditNum;

	private boolean approve = true;// 信用卡检查是否通过

	private CreditCard creditCard;// 发放的信用卡对象

	public UserInfo(String username, boolean sex, int age, int degree, String phone, String company, String title,
			int salary, boolean hasHouse, boolean hasCar, int CreditNum) {
		this.username = username;
		this.sex = sex;
		this.age = age;
		this.degree = degree;
		this.phone = phone;
		this.company = company;
		this.title = title;
		this.salary = salary;
		this.hasHouse = hasHouse;
		this.hasCar = hasCar;
		this.CreditNum = CreditNum;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public boolean isHasHouse() {
		return hasHouse;
	}

	public void setHasHouse(boolean hasHouse) {
		this.hasHouse = hasHouse;
	}

	public boolean isHasCar() {
		return hasCar;
	}

	public void setHasCar(boolean hasCar) {
		this.hasCar = hasCar;
	}

	public int getCreditNum() {
		return CreditNum;
	}

	public void setCreditNum(int CreditNum) {
		this.CreditNum = CreditNum;
	}

	public boolean isApprove() {
		return approve;
	}

	public void setApprove(boolean approve) {
		this.approve = approve;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	@Override
	public String toString() {
		return "UserInfo [username=" + username + ", sex=" + sex + ", age=" + age + ", degree=" + degree + ", phone="
				+ phone + ", company=" + company + ", title=" + title + ", salary=" + salary + ", hasHouse=" + hasHouse
				+ ", hasCar=" + hasCar + ", CreditNum=" + CreditNum + ", approve=" + approve + ", creditCard="
				+ creditCard + "]";
	}

}
