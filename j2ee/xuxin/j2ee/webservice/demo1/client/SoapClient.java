/**
 * 
 */
package xuxin.j2ee.webservice.demo1.client;

import java.rmi.RemoteException;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import xuxin.j2ee.webservice.demo1.client.wsdl2java.IHelloService;
import xuxin.j2ee.webservice.demo1.client.wsdl2java.Student;


/**
 * @version 1.0
 * @author xuxin 
 * @data 2013-6-3
 */
public class SoapClient {

    public static void main(String[] args) throws RemoteException {
        /*************************方法一******************************/
        JaxWsProxyFactoryBean soapFactoryBean = new JaxWsProxyFactoryBean();
        soapFactoryBean.setAddress("http://127.0.0.1:8080/helloService");
        soapFactoryBean.setServiceClass(IHelloService.class);
        Object o = soapFactoryBean.create();
        IHelloService helloService = (IHelloService) o;
        
        Student s1 = new Student();
        s1.setName("kobe");
        Student s2 = new Student();
        s2.setName("james");
        
        System.out.println(helloService.selectMaxLongNameStudent(s1, s2).getName());
        
        /*************************方法二******************************/
        
    }
}
