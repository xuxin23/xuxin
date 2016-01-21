package xuxin.j2se.thread.demo4ReentrantReadWriteLock;

/**
 * 购买基金
 * @author xuxin
 *
 */
public class RunnableB implements Runnable{

	private Bank bank;
	
	public RunnableB(Bank bank) {
		this.bank  = bank;
	}
	
	public void run() {
		while (true) {
			try {
				Thread.sleep((long) (5000 + Math.random() * 50000));
				bank.buyCount((int) (1000 + Math.random() * 4000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
