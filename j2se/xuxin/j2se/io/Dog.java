package xuxin.j2se.io;

import java.io.Serializable;

public class Dog implements Serializable{
	
	private static int count;
	private int num;
	private String name;
	private int age;
	
	public Dog(String name, int age) {
		this.name = name;
		this.age = age;
		this.num = Dog.count++;
	}

	public int getNum() {
		return num;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

}
