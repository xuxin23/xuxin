package xuxin.j2se.thread.demo1Synchronized;

import java.util.ArrayList;

/**
 * 验证线程的例子：厨师和顾客
 * Food类：负责厨师和顾客的同步---一个盘子，空了厨师做，满了顾客吃
 * 注意：这个多线程共同访问的类一般需要同步即synchronized
 * 1.当线程访问一个被synchronized修饰的方法时，那么该线程就拿到这个对象的锁(不仅仅是这个方法)
 *   该对象的所有资源都不能被别的线程或对象访问，直到该线程释放该对象的锁。
 * 2.synchronized和wait/notify是组合使用的;其中wait和sleep是完全不同的
 *      |-一个synchronized方法被访问时，访问者获取锁。wait方法是当前线程放弃对锁的占用，别的线程可以
 *        获取对象锁来操作，直到当前线程被唤醒。(唤醒后会接着上次执行的位置开始执行...)
 *      |-wait/notify是为了对象锁使用的，而sleep则是为了线程使用的。当在一个synchronized方法中使用
 *        sleep方法时，该线程会睡眠指定时间再恢复执行，但在此期间该线程并没有放弃对象锁，别的线程无法
 *        访问该对象。
 * @author xuxin
 *
 */
public class Food {
	
	//以数字模拟菜
	private int num = 0;
	//盘子，用来存放菜
	private ArrayList<Integer> foodList = new ArrayList<Integer>();
	
	/*
	 * 生产菜，当盘子满时等待，盘子空时做菜
	 */
	public synchronized void cook() {
		//盘子已满，厨师等待
		if (foodList.size() == 1) {
			try {
				System.out.println("盘子满了..等客人吃完..");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//该线程被notify时就到下面的代码了..
		//生产菜放进盘子
		num++;
		foodList.add(num);
		System.out.println("生产出" + num + "号菜..");
		//叫顾客来吃
		notify();
		
	}
	
	/*
	 * 吃菜，当盘子空时等待，当盘子满时吃菜
	 */
	public synchronized void eat() {
		//盘子空了等待厨师上菜
		if (foodList.size() == 0) {
			try {
				System.out.println("盘子空了..等厨师上菜..");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//该线程被notify时就到下面的代码了..
		//将盘子里的菜吃掉
		int e = foodList.remove(0);
		System.out.println("吃掉" + e + "号菜..");
		//叫厨师上菜
		notify();
	}
}
