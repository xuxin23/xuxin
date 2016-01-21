package xuxin.j2se.thread.demo1Synchronized;

/**
 * 验证线程的例子：厨师和顾客
 * Customer类:吃掉20份菜
 * @author Administrator
 *
 */
public class Customer implements Runnable{
	
	private Food food;
	public Customer(Food food) {
		this.food = food;
	}
	
	public void run() {
		System.out.println("准备吃饭咯！");
		for (int i=0; i<20; i++) {
//			System.out.println("------------------Customer次数:" + (i + 1) + "--------------");
			int time = (int) (Math.random() * 2000);
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			food.eat();
			
		}
	}
}
