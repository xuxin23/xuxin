package xuxin.j2se.thread.demo2Interrupted;

public class Client {

	public static void main(String[] args) {
		// 创建线程组
		ThreadGroup group = new ThreadGroup("testGroup");
		
		// 为该组创建线程
		Thread count = new Thread(group, new RunnableCount(), "countRunnableInGroup");
		Thread add = new Thread(group, new RunnableAdd(), "addRunnableInGroup");
		
		// 为默认组创建线程
		Thread single = new Thread(new RunnableAdd(), "single");
		
		count.start();
		add.start();
		single.start();
		
		try {
			// 主线程睡眠5秒
			Thread.sleep(5000);
			// 从主线程中向线程组发送interrupted中止命令
			group.interrupt();
			
			Thread.sleep(2000);
			// 从主线程向线程发送interrupted中止命令
			single.interrupt();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
