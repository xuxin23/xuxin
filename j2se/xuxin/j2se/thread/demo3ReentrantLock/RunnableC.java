package xuxin.j2se.thread.demo3ReentrantLock;

/**
 * 测试线程C
 * [不停的取美金]
 * @author xuxin
 *
 */
public class RunnableC implements Runnable{

	private Bank bank;
	
	public RunnableC(Bank bank) {
		this.bank = bank;
	}
	
	public void run() {
		while (true) {
			try {
				Thread.sleep((long) (2000 + Math.random() * 4000));
				bank.outUs((int) (500 + Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
