package xuxin.j2se.annotation;

public class Dog {
	private String name;
	private int age;
	private String type;
	private String address;
	private int money;
	private String skills;
	
	@DefaultAnnotation(getString="狗窝")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@DefaultAnnotation(getInt=10000)
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	@DefaultAnnotation(getString="看家")
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	@DefaultAnnotation(getString="牧狼犬")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@DefaultAnnotation
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
