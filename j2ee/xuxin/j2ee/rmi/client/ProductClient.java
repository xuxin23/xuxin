package xuxin.j2ee.rmi.client;

import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import xuxin.j2ee.rmi.server.IProduct;
import xuxin.j2ee.rmi.server.NiceBook;


/**
 * RMI客户端程序
 * @author xuxin
 * @date 2013-7-29
 */
public class ProductClient {

	public static void main(String[] args) {
		// 设置策略文件名称（指示安全管理器去读取）
		System.setProperty("java.security.policy", "client.policy");
		// 安装安全管理器
		System.setSecurityManager(new RMISecurityManager());
		
		String url = "rmi://localhost/";
		try {
			Context ctx = new InitialContext();
			IProduct p1 = (IProduct) ctx.lookup(url + "core");
			IProduct p2 = (IProduct) ctx.lookup(url + "think");
			
			System.out.println(p1.getDescription());
			System.out.println(p2.getDescription());
			
			// 复制的参数对象
			NiceBook book = p1.getBook();
			book.test();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
