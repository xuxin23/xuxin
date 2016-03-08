package xuxin.j2se.thread.demo3ReentrantLock;

import xuxin.j2se.thread.demo3ReentrantLock.Bank;
import xuxin.j2se.thread.demo3ReentrantLock.InRunnable;
import xuxin.j2se.thread.demo3ReentrantLock.OutRunnable;

public class Client {

	public static void main(String[] args) {
		Bank bank = new Bank(2500);
		Thread in1 = new Thread(new InRunnable(bank),"in1");
		Thread out1 = new Thread(new OutRunnable(bank),"out1");
		Thread out2 = new Thread(new OutRunnable(bank),"out2");
		
		in1.start();
		out1.start();
		out2.start();
	}
}
