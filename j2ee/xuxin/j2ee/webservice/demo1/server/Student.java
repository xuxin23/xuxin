/**
 * Student.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xuxin.j2ee.webservice.demo1.server;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Student")
public class Student{
    private String id;

    private String name;
    
    private Date birthday;
    
    public Student() {}

    public String toString() {
        return "{name:" + this.name + "}";
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
    
}
