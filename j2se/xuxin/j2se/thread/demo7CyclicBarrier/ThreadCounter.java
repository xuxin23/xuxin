package xuxin.j2se.thread.demo7CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ThreadCounter implements Runnable{

	private static int count;
	
	private CyclicBarrier barrier;
	private int sleepTime;
	
	public ThreadCounter(CyclicBarrier barrier, int sleepTime) {
		this.barrier = barrier;
		this.sleepTime = sleepTime;
	}
	
	public static int getCount() {
		return count;
	}

	public void run() {
		try {
			Thread.sleep(sleepTime);
			count++;
			barrier.await();
			System.out.println("一共有" + getCount() + "个线程一起越过障栅..\tFrom " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		
	}
	
}
