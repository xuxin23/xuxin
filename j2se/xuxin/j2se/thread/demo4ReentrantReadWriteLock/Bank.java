package xuxin.j2se.thread.demo4ReentrantReadWriteLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 同步对象[银行基金数量]
 * @author xuxin
 * @date 2013-07-05
 */
public class Bank {

	// 默认基金剩余数量
	private int count = 100000;
	
	// 默认基金最高数量
	private int max = 100000;
	
	// ReentrantReadWriteLock对象
	private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	
	// 读锁
	private Lock readLock = rwl.readLock();
	
	// 写锁
	private Lock writeLock = rwl.writeLock();
	
	// 基金余额不足条件对象
	private Condition lowerCondition = writeLock.newCondition();
	
	// 基金余额超额条件对象
	private Condition highConditon = writeLock.newCondition();
	
	public Bank() {}
	public Bank(int count, int max) {
		this.count = count;
		this.max  = max;
	} 
	
	// 顾客查询基金数量
	public void getcount() {
		readLock.lock();
		try {
			String name = Thread.currentThread().getName();
			System.out.println("(" + name + ")\t\t开始查询基金剩余数量..");
			Thread.sleep((long) (2000 + 2000 * Math.random()));
			System.out.println("(" + name + ")\t\t查询基金剩余数量为 " + this.count);
			System.out.println();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			readLock.unlock();
		}
	}
	
	// 顾客购买基金数量
	public void buyCount(int count) {
		writeLock.lock();
		try {
			String name = Thread.currentThread().getName();
			if (count > this.count) {
				System.out.println("(" + name + ")\t\t基金数量不足..");
				System.out.println();
				lowerCondition.await();
			} else {
				System.out.println("(" + name + ")\t\t开始购买基金..");
				Thread.sleep((long) (2000 + 2000 * Math.random()));
				this.count -= count;
				System.out.println("(" + name + ")\t\t购买基金数量为 " + count + "[剩余基金数量为 " + this.count + "]");
				System.out.println();
				// 提醒阻塞的银行员工可以尝试增加基金
				highConditon.signalAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			writeLock.unlock();
		}
	}
	
	// 银行增加基金数量
	public void addCount(int count) {
		writeLock.lock();
		try {
			String name = Thread.currentThread().getName();
			if (this.count + count > this.max) {
				System.out.println("(" + name + ")\t\t基金数量超额..");
				System.out.println();
				highConditon.await();
			} else {
				System.out.println("(" + name + ")\t\t开始增加基金数量");
				Thread.sleep((long) (2000 + 2000 * Math.random()));
				this.count += count;
				System.out.println("(" + name + ")\t\t增加基金数量 " + count + "[剩余基金数量为 " + this.count + "]");
				System.out.println();
				// 提醒阻塞的购买顾客可以尝试购买基金
				lowerCondition.signalAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			writeLock.unlock();
		}
	}
}
