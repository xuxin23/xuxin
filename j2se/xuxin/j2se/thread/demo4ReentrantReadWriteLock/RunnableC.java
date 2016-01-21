package xuxin.j2se.thread.demo4ReentrantReadWriteLock;

/**
 * 增加基金
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
				Thread.sleep((long) (40000 + 30000 * Math.random()));
				bank.addCount((int) (5000 + 50000 * Math.random()));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
