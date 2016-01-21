package xuxin.j2se.annotation;

public class Cat {
	private String name;
	private int age;
	private String type;
	private String address;
	private int money;
	private String skills;
	
	@DefaultAnnotation(getString="猫窝")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@DefaultAnnotation(getInt=1000)
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	@DefaultAnnotation(getString="捉老鼠")
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	@DefaultAnnotation(getString="流浪猫")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@DefaultAnnotation(getInt=3)
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@DefaultAnnotation(getString="类型什么的随便吧")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
