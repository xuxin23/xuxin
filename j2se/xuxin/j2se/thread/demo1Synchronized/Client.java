package xuxin.j2se.thread.demo1Synchronized;

/**
 * 验证线程的例子
 * 注意：新建线程有2种方式
 * 1.继承Thread类，然后重写run()方法，那么新的线程start()的时候就会调用子类重写的run()的逻辑
 * 2.实现Runnable接口，传入接口的实例新建线程，那么新的线程start()的时候就会调用传入的Runable
 *   接口实例的run()的逻辑(接口嘛...)
 * @author xuxin
 *
 */
public class Client {
	
	public static void main(String[] args) {
		Food food = new Food();
		Cooker cooker = new Cooker(food);
		Customer customer = new Customer(food);
		
		//通过Runnable接口新建线程的例子
		Thread t1 = new Thread(cooker);
		Thread t2 = new Thread(customer);
		//调用线程的本地方法start()启动线程
		t1.start();
		t2.start();
	}
}
