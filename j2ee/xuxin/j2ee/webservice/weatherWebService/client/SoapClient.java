package xuxin.j2ee.webservice.weatherWebService.client;

import java.util.List;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import xuxin.j2ee.webservice.weatherWebService.client.wsdl2java.ArrayOfString;
import xuxin.j2ee.webservice.weatherWebService.client.wsdl2java.WeatherWebServiceSoap;


/**
 * 天气预报webservice
 * @author xuxin
 * @data 2013-12-02
 *
 */
public class SoapClient {

	public static void main(String[] args) {
		JaxWsProxyFactoryBean soapFactoryBean = new JaxWsProxyFactoryBean();
		soapFactoryBean.setAddress("http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl");
		soapFactoryBean.setServiceClass(xuxin.j2ee.webservice.weatherWebService.client.wsdl2java.WeatherWebServiceSoap.class);
		Object o = soapFactoryBean.create();
		WeatherWebServiceSoap weather = (WeatherWebServiceSoap)o;
		
		ArrayOfString info = weather.getWeatherbyCityName("上海");
		List<String> infoList = info.getString();
		for (String str:infoList) {
			System.out.println(str);
		}
	}
}
