package xuxin.j2se.thread.demo1Synchronized;

/**
 * 验证线程的例子:厨师与顾客
 * Cooker类:做20份菜
 * @author Administrator
 *
 */
public class Cooker implements Runnable{
	
	private Food food;
	public Cooker(Food food) {
		this.food = food;
	}
	
	public void run() {
		System.out.println("马上干活咯!");
		for (int i=0; i<20; i++) {
			int time = (int) (Math.random() * 2000);
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			food.cook();
			
		}
	}
}
