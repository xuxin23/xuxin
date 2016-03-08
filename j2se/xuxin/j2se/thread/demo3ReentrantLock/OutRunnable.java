package xuxin.j2se.thread.demo3ReentrantLock;

import xuxin.j2se.thread.demo3ReentrantLock.Bank;

/**
 * 取钱线程
 * @author Administrator
 *
 */
public class OutRunnable implements Runnable{

	private Bank bank;
	
	public OutRunnable(Bank bank) {
		this.bank = bank;
	}

	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			bank.outRmb(600);
		}
		try {
			Thread.sleep((long) (Math.random()*1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
