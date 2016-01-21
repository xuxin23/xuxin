package xuxin.j2ee.rmi.server;

import java.io.Serializable;

/**
 * RMI参数传递的对象
 * @author xuxin
 * @date 2013-7-30
 */
public class NiceBook implements Serializable{

	private static final long serialVersionUID = -7914784091073535310L;

	private String name = "default";
	
	public NiceBook() {
		
	}
	
	public NiceBook(String name) {
		this.name = name;
	}
	
	public void test() {
		System.out.println("书名：" + this.name);
	}
}
