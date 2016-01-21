package xuxin.j2se.thread.demo3ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 同步对象(ATM机)
 * @author xuxin
 *
 */
public class Bank {

	// 默认人民币余额
	private int rmb = 10000;
	// 默认美金余额
	private int us = 5000;
	
	// 可重入锁对象
	private Lock bankLock = new ReentrantLock();
	
	// 人民币余额不足条件对象
	private Condition rmbCondition = bankLock.newCondition();
	
	// 美金余额不足条件对象
	private Condition usCondition = bankLock.newCondition();
	
	public Bank() {}
	
	public Bank(int rmb, int us) {
		this.rmb = rmb;
		this.us = us;
	}
	
	// 取人民币
	public void outRmb(int rmb) {
		bankLock.lock();
		try {
			String name = Thread.currentThread().getName();
			if (this.rmb < rmb) {
				System.out.println("(" + name + ")\t\t人民币余额不足..");
				System.out.println();
				rmbCondition.await();
			} 
			System.out.println("(" + name + ")\t\t开始取人民币..");
			this.rmb -= rmb;
			// 模拟取钱消耗时间(1~10s)
			Thread.sleep((long) (1000 + Math.random() * 9000));
			System.out.println("(" + name + ")\t\t取出人民币" + rmb + "元[剩余" + this.rmb + "元]");
			System.out.println();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			bankLock.unlock();
		}
		
	}
	
	// 取美金
	public void outUs(int us) {
		bankLock.lock();
		try {
			String name = Thread.currentThread().getName();
			if (this.us < us) {
				System.out.println("(" + name + ")\t\t美金余额不足..");
				System.out.println();
				usCondition.await();
			}
			System.out.println("(" + name + ")\t\t开始取美金..");
			this.us -= us;
			// 模拟取钱消耗时间(1~5s)
			Thread.sleep((long) (1000 + Math.random() * 4000));
			System.out.println("(" + name + ")\t\t取出美金" + us + "元[剩余" + this.us + "元]");
			System.out.println();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			bankLock.unlock();
		}
	}
	
	// 存人民币
	public void inRmb(int rmb) {
		bankLock.lock();
		try {
			String name = Thread.currentThread().getName();
			System.out.println("(" + name + ")\t\t开始存人民币..");
			this.rmb += rmb;
			// 模拟存钱消耗时间(5~10s)
			Thread.sleep((long) (5000 + Math.random() * 5000));
			System.out.println("(" + name + ")\t\t存入人民币" + rmb + "元[剩余" + this.rmb + "元]");
			System.out.println();
			rmbCondition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			bankLock.unlock();
		}
		
	}
	
	// 存美金
	public void inUs(int us) {
		bankLock.lock();
		try {
			String name = Thread.currentThread().getName();
			System.out.println("(" + name + ")\t\t开始存美金..");
			this.us += us;
			// 模拟存钱消耗时间(5~10s)
			Thread.sleep((long) (5000 + Math.random() * 5000));
			System.out.println("(" + name + ")\t\t存入美金" + us + "元[剩余" + this.us + "元]");
			System.out.println();
			usCondition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			bankLock.unlock();
		}
	}
}
