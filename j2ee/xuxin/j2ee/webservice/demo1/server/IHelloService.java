/**
 * IHellowService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xuxin.j2ee.webservice.demo1.server;

import javax.jws.WebService;

import xuxin.j2ee.webservice.demo1.server.Student;


@WebService
public interface IHelloService{
    Student selectMaxLongNameStudent(Student s1, Student s2);
    Student selectMaxAgeStudent(Student s1, Student s2);
}
