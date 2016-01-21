package xuxin.j2se.thread.demo2Interrupted;

/**
 * 测试线程
 * @author xuxin
 * @date 2013-07-05 10:18:35
 */
public class RunnableAdd implements Runnable{

	public void run() {
		int i = 1;
		int count = 0;
		while (true) {
			String name = Thread.currentThread().getName();
			if (!Thread.currentThread().isInterrupted()) {
				count += i++;
				System.out.println(name + " : " + count);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					System.out.println("线程" + name + "处理InterruptedException异常..");
					Thread.currentThread().interrupt();
				}
			} else {
				System.out.println("线程" + name + "接收到中止命令！");
				break;
			}
		}
		String name2 = Thread.currentThread().getName();
		System.out.println("线程" + name2 + "结束！");
	}

}
