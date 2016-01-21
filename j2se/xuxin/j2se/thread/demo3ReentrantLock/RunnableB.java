package xuxin.j2se.thread.demo3ReentrantLock;

/**
 * 测试线程B
 * [不停的取人民币]
 * @author xuxin
 *
 */
public class RunnableB implements Runnable{

	private Bank bank;
	
	public RunnableB(Bank bank) {
		this.bank = bank;
	}
	
	public void run() {
		while (true) {
			try {
				Thread.sleep((long) (5000 + Math.random() * 8000));
				bank.outRmb((int) (1000 + Math.random() * 10000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
