package xuxin.j2se.thread.demo4ReentrantReadWriteLock;

/**
 * 查询基金数量
 * @author xuxin
 *
 */
public class RunnableA implements Runnable{

	private Bank bank;
	
	public RunnableA(Bank bank) {
		this.bank = bank;
	}
	
	public void run() {
		while (true) {
			try {
				Thread.sleep((long) (1000 + Math.random() * 2000));
				bank.getcount();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
