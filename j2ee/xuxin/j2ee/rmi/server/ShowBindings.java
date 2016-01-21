package xuxin.j2ee.rmi.server;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

/**
 * 列举远程对象（辅助测试服务器端是否正常启动并运行）
 * @author xuxin
 * @date 2013-7-29
 */
public class ShowBindings {

	public static void main(String[] args) {
		try {
			Context ctx = new InitialContext();
			NamingEnumeration<NameClassPair> e = ctx.list("rmi:");
			while (e.hasMore()) {
				System.out.println(e.next().getName());
				
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
