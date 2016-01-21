/**
 * 
 */
package xuxin.j2ee.webservice.demo1.server;

import xuxin.j2ee.webservice.demo1.server.IHelloService;

/**
 * @version 1.0
 * @author xuxin 
 * @data 2013-6-3
 */
public class HelloServiceImpl implements IHelloService{

    public Student selectMaxAgeStudent(Student s1, Student s2) {
        return s1;
    }

    public Student selectMaxLongNameStudent(Student s1, Student s2) {
        if (s1.getName().length() > s2.getName().length()) {
            return s1;
        } else {
            return s2;
        }
    }

}
