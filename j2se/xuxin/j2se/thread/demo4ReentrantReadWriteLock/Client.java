package xuxin.j2se.thread.demo4ReentrantReadWriteLock;

/**
 * 
 * @author xuxin
 * @date 2013-7-5
 */
public class Client {

	public static void main(String[] args) {
		Bank bank = new Bank(10000, 20000);
		Thread a1 = new Thread(new RunnableA(bank), "查询1号");
		Thread a2 = new Thread(new RunnableA(bank), "查询2号");
//		Thread a3 = new Thread(new RunnableA(bank), "查询3号");
//		Thread a4 = new Thread(new RunnableA(bank), "查询4号");
		Thread b1 = new Thread(new RunnableB(bank), "购买1号");
		Thread b2 = new Thread(new RunnableB(bank), "购买2号");
		Thread c1 = new Thread(new RunnableC(bank), "增加1号");
		
		a1.start();
		a2.start();
//		a3.start();
//		a4.start();
		b1.start();
		b2.start();
		c1.start();
	}
}
