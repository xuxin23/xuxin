package xuxin.j2se.thread.demo3ReentrantLock;

public class Client {

	public static void main(String[] args) {
		Bank bank = new Bank(10000, 3000);
		
		Thread a = new Thread(new RunnableA(bank), "矮穷挫");
		Thread b = new Thread(new RunnableB(bank), "郭美美");
		Thread c = new Thread(new RunnableC(bank), "詹姆斯");
		Thread d = new Thread(new RunnableD(bank), "银行员");
		
		a.start();
		b.start();
		c.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		d.start();
	}
}
