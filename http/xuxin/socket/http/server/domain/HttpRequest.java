package xuxin.socket.http.server.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * 请求上下文
 * @author xuxin
 *
 */
public class HttpRequest {

	// 请求数据
	private Map<String,Object> parameterMap = new HashMap<String,Object>();
	// 属性
	private Map<String,Object> attributeMap = new HashMap<String,Object>();
	
	/**
	 * 设置请求数据
	 * @param key
	 * @param data
	 */
	public void setParameter(String key,String data) {
		this.parameterMap.put(key, data);
	}
	
	/**
	 * 获取请求数据
	 * @param key
	 * @return
	 */
	public String getParameter(String key) {
		return (String) this.parameterMap.get(key);
	}
	
	/**
	 * 设置上下文属性
	 * @param key
	 * @param data
	 */
	public void setAttribute(String key,String data) {
		this.attributeMap.put(key, data);
	}
	
	/**
	 * 获取上下文属性
	 * @param key
	 * @return
	 */
	public String getAttribute(String key) {
		return (String) this.attributeMap.get(key);
	}
}
