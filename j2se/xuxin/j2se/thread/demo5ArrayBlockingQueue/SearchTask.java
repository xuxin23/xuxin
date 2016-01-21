package xuxin.j2se.thread.demo5ArrayBlockingQueue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

/**
 * 文本搜索任务
 * @author xuxin
 * @date 2013-7-8
 */
public class SearchTask implements Runnable{

	// 提取文件的队列
	private BlockingQueue<File> queue;
	// 搜索的文本
	private String keyword;
	// 搜索任务结束标志
	public static boolean done = false;
	
	public SearchTask(BlockingQueue<File> queue, String keyword) {
		this.queue = queue;
		this.keyword = keyword;
	}
	
	public void run() {
		while (!done) {
			if (!Thread.currentThread().isInterrupted()) {
				try {
					File file = queue.take();
					if (file == FileEnumerationTask.ENDFILE) {
						done = true;
						System.out.println("------------------发现最后的标志文件------------------");
					} else {
						search(file);
					}
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			} else {
				break;
			}
		}
	}

	public void search(File file) throws FileNotFoundException {
		Scanner in = new Scanner(file);
		int lineNumber = 0;
		
		boolean printFlag = false;
		while (in.hasNextLine()) {
			lineNumber++;
			String line = in.nextLine();
			if (line.contains(keyword)) {
				if (!printFlag) {
					System.out.println();
					System.out.println(file.getPath() + "\t[" + Thread.currentThread().getName() + "]");
					printFlag = true;
				}
				System.out.println("\t" + lineNumber + "行\t" + line);
			}
		}
	}
}
