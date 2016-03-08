package xuxin.j2se.thread.demo3ReentrantLock;

import xuxin.j2se.thread.demo3ReentrantLock.Bank;

/**
 * 存钱线程
 * @author Administrator
 *
 */
public class InRunnable implements Runnable{

	private Bank bank;
	
	public InRunnable(Bank bank) {
		this.bank = bank;
	}
	
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			bank.inRmb(1000);
			try {
				Thread.sleep((long) (Math.random()*1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
