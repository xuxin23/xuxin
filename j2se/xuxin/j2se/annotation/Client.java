package xuxin.j2se.annotation;

import java.lang.reflect.InvocationTargetException;

public class Client {
	public static void main(String[] args) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException {
		Person person = ObjectFactory.createObject(Person.class);
		Dog dog = ObjectFactory.createObject(Dog.class);
		Cat cat = ObjectFactory.createObject(Cat.class);
		System.out.println("----------Person----------");
		System.out.println("=person.number=" + person.getNumber());
		System.out.println("=person.name=" + person.getName());
		System.out.println("=person.age=" + person.getAge());
		System.out.println("----------Dog-------------");
		System.out.println("=dog.name=" + dog.getName());
		System.out.println("=dog.age=" + dog.getAge());
		System.out.println("=dog.address=" + dog.getAddress());
		System.out.println("=dog.type=" + dog.getType());
		System.out.println("=dog.money=" + dog.getMoney());
		System.out.println("=dog.skills=" + dog.getSkills());
		System.out.println("-----------Cat------------");
		System.out.println("=cat.name=" + cat.getName());
		System.out.println("=cat.age=" + cat.getAge());
		System.out.println("=cat.address=" + cat.getAddress());
		System.out.println("=cat.type=" + cat.getType());
		System.out.println("=cat.money=" + cat.getMoney());
		System.out.println("=cat.skills=" + cat.getSkills());
	}
}
