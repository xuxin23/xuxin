package xuxin.j2se.thread.demo3ReentrantLock;

/**
 * 测试线程D
 * [不停的存人民币和美金]
 * @author xuxin
 *
 */
public class RunnableD implements Runnable{

	private Bank bank;
	
	public RunnableD(Bank bank) {
		this.bank = bank;
	}
	
	public void run() {
		while (true) {
			try {
				Thread.sleep((long) (10000 + Math.random() * 3000));
				bank.inRmb(1500);
				bank.inUs(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
