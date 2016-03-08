package xuxin.j2se.thread.demo3ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {

	// 余额初始值
	private int rmb = 0;
	// 可重入锁对象
	private Lock bankLock = new ReentrantLock();
	// 余额不足条件
	private Condition rmbCondition = bankLock.newCondition();
	
	public Bank(int rmb) {
		this.rmb = rmb;
	}
	
	/**
	 * 存钱
	 * @param d
	 */
	public void inRmb(int d) {
		bankLock.lock();
		rmb += d;
		System.out.println("+" + d);
		System.out.println("[" + Thread.currentThread().getName() + "] 存入" + d + "元，当前余额：" + rmb + "元");
		rmbCondition.signalAll();
		bankLock.unlock();
	}
	
	/**
	 * 取钱
	 * @param money
	 */
	public void outRmb(int money) {
		bankLock.lock();
		boolean flag = true;
		// 为什么加循环？因为该场景需要判断余额是否足够，而每次解除阻塞并不表示余额足够，需要循环判断
		while (flag) {
			if (rmb < money) {
				System.out.println("-" + money);
				System.out.println("[" + Thread.currentThread().getName() + "] 当前余额不足：" + rmb);
				try {
					rmbCondition.await();
					// 当条件对象被解除阻塞时，需要再次判断此时的余额是否足够而不是直接进入取钱操作
					// 足够则跳出循环；
					if (rmb >= money) {
						break;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				break;
			}
		}
		rmb -= money;
		System.out.println("[" + Thread.currentThread().getName() + "] 取出" + money + "元，当前余额：" + rmb + "元");
		bankLock.unlock();
	}
}
