package xuxin.j2se.thread.demo2Interrupted;

/**
 * 测试线程
 * @author xuxin
 *
 */
public class RunnableCount implements Runnable{

	public void run() {
		int i = 1;
		while (true) {
			String name = Thread.currentThread().getName();
			// 循环检查interrupted标志位
			if (!Thread.currentThread().isInterrupted()) {
				System.out.println(name + " ：" + i++);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// 处理interruptedException异常，向当前线程发送interrupted指令
					System.out.println("线程" + name + "处理InterruptedException异常..");
					Thread.currentThread().interrupt();
				}
			} else {
				// 处理interrupted命令
				System.out.println("线程" + name + "接收到中止命令！");
				break;
			}
		}
		String name2 = Thread.currentThread().getName();
		System.out.println("线程" + name2 + "结束！");
	}

}
