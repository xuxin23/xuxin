package xuxin.j2ee.rmi.server;

import java.rmi.RemoteException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * RMI客户端程序
 * @author xuxin
 * @date 2013-7-29
 */
public class ProductServer {

	public static void main(String[] args) {
		try {
			ProductImpl p1 = new ProductImpl("Core Java2");
			ProductImpl p2 = new ProductImpl("Thinking in java");
			
			System.out.println("Binding server implementations to registry...");
			Context ctx = new InitialContext();
			ctx.bind("rmi:core", p1);
			ctx.bind("rmi:think", p2);
			p1.setBook(new NiceBook("Core Java高级特性"));
			p2.setBook(new NiceBook("深入分析Java Web技术内幕"));
			System.out.println("Waiting for invocations from clients...");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
