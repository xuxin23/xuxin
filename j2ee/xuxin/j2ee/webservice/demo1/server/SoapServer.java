/**
 * 
 */
package xuxin.j2ee.webservice.demo1.server;

import javax.xml.ws.Endpoint;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**
 * 发布服务
 * @version 1.0
 * @author xuxin 
 * @data 2013-6-3
 */
public class SoapServer {

    public static void main(String[] args) {
        
        /*************************方法一******************************/
        JaxWsServerFactoryBean soapFactoryBean = new JaxWsServerFactoryBean();
        // 拦截器用于输出“Web服务端发送和接收消息时的信息”
        soapFactoryBean.getInInterceptors().add(new LoggingInInterceptor());
        soapFactoryBean.getOutInterceptors().add(new LoggingOutInterceptor());
        // 注意这里是实现类不是接口
        soapFactoryBean.setServiceClass(HelloServiceImpl.class);
        soapFactoryBean.setAddress("http://127.0.0.1:8080/helloService");
        soapFactoryBean.create();
        
        /*************************方法二******************************/
        /*Endpoint.publish("http://127.0.0.1:8080/helloService", new HelloServiceImpl());*/
    }
}
