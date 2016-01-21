package xuxin.j2se.thread.demo3ReentrantLock;

/**
 * 测试线程A
 * [不停的取人民币]
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
				Thread.sleep((long) (2000 + Math.random() * 5000));
				bank.outRmb((int) (100 + Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
