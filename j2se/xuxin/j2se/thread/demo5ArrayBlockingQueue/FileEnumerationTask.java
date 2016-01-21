package xuxin.j2se.thread.demo5ArrayBlockingQueue;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * 文件扫描任务
 * @author xuxin
 * @date 2013-7-8
 */
public class FileEnumerationTask implements Runnable{

	// 存放文件的队列
	private BlockingQueue<File> queue;
	// 搜索的文件夹
	private File dir;
	// 结束标志文件(静态，在SearchTask任务中需要用到)
	public static File ENDFILE = new File("");
	// 扫描的文件个数
	public static int fileNum = 0;
	
	public FileEnumerationTask(BlockingQueue<File> queue, File dir) {
		this.queue = queue;
		this.dir = dir;
	}
	
	public void run() {
		try {
			enumerate(dir);
			queue.put(ENDFILE);
			System.out.println("----------------------文件扫描任务结束-----------------------");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enumerate(File dir) throws InterruptedException {
		File[] files = dir.listFiles();
		for (File file:files) {
			if (file.isDirectory()) {
				fileNum++;
				enumerate(file);
			} else {
				queue.put(file);
			}
		}
	}
}
