package xuxin.j2se.base;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

/**
 * 重写Comparable接口，以便在集合中用sort排序
 * @author Administrator
 *
 */

public class ComparableDemo {
	@Test
    public void test() {
	    ArrayList<Student> list = new ArrayList<Student>();
	    list.add(new Student("kobe",34));
	    list.add(new Student("james",28));
	    list.add(new Student("wade",30));
	    
	    Collections.sort(list);
	    for (Student s:list) {
	        System.out.println(s);
	    }
	}
}

class Student implements Comparable{
    private String name;
	private int age;
	
	public Student() {}
	
	public Student(String name, int age) {
	    this.name = name;
		this.age = age;
	}
	
	public String toString() {
	    return "{name=" + name + ", age=" + age + "}";
	}
	
	public int getAge() {
		return this.age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int compareTo(Object obj) {
		if (this == obj) {
			return 0;
		}
		if (obj != null && obj.getClass().equals(Student.class)) {
			Student student = (Student)obj;
			return this.age - student.getAge();
		}
		return 0;
	}
}
