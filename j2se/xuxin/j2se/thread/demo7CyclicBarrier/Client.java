package xuxin.j2se.thread.demo7CyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * 这里只是简单的一个障栅例子，类似的还有门栓、交换器、同步队列等
 * @author xuxin
 * @date 2013-7-15
 */
public class Client {

	public static void main(String[] args) {
		
		CyclicBarrier barrier = new CyclicBarrier(3);
		
		Thread t1 = new Thread(new ThreadCounter(barrier, 3000), "thread1");
		Thread t2 = new Thread(new ThreadCounter(barrier, 5000), "thread2");
		Thread t3 = new Thread(new ThreadCounter(barrier, 1000), "thread3");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
