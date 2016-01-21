package xuxin.j2se.thread.demo5ArrayBlockingQueue;

import java.io.File;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 用线程安全的队列处理多线程同步
 * [实现文本搜索功能]
 * 注：
 * 		1. BlockingQueue的put/take阻塞
 * 		2. 巧用最后标志文件
 * 		3. 理解“当发现最后标志文件时，被阻塞的文本搜索线程无法自动中断” ...好好想明白
 * 		4. 由主线程检查文本搜索任务是否结束并在结束后中断所有文本搜索线程
 * 			4.1 为了控制所有的文本搜索线程，将它们放入一个线程组
 * 			4.2 文本搜索线程设置一个static boolean的变量表示是否发现最后标志文件
 * 			4.3 主线程轮询该变量，为true时，向文本搜索线程组发送中断请求
 * 			4.4 因为文本搜索线程需要处理interrupt中断请求，所以这些线程需要判断当前
 * 				线程的interrupted标志并作出处理，同时由于向被阻塞的线程发送interrupt
 * 				中断请求会抛出InterruptedException，所以需要在catch中处理异常向当前
 * 				线程再次发送interrupt中断请求。
 * 		
 * @author xuxin
 * @date 2013-7-8
 */
public class Client {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("请输入搜索的文件夹:");
		String dir = in.nextLine();
		System.out.println("请输入搜索的文本:");
		String keyword = in.nextLine();
		
		// 程序开始时间
		long startTime = new Date().getTime();
		// 程序结束时间
		long endTime;
		// 存放文件的队列大小
		final int FILE_QUEUE_SIZE = 10;
		// 文本搜索线程个数
		final int SEARCH_THREADS = 100;
		// 存放文件的队列
		BlockingQueue<File> queue = new ArrayBlockingQueue<File>(FILE_QUEUE_SIZE);
		
		new Thread(new FileEnumerationTask(queue, new File(dir))).start();
		ThreadGroup group = new ThreadGroup("searchTaskGroup");
		for (int i=0; i<SEARCH_THREADS; i++) {
			new Thread(group, new SearchTask(queue, keyword), "thread" + i).start();
		}
		
		// 检查搜索任务线程组是否全部结束
		// 线程使用队列来控制同步，任务结束后被阻塞的线程无法自动中断
		// 解决办法：放置一个标志最后一个文件的文件到队列中，当某个线程发现了这个文件，则将
		// SearchTask.done 设置为true,主线程轮询这个标志,如果为true则向线程组发送中断请求
		boolean done = false;
		while (!done) {
			try {
				if (SearchTask.done) {
					done = true;
					group.interrupt();
				}
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// 程序结束时间
		endTime = new Date().getTime();
		System.out.println("搜索结束，共用时间 " + new Date(endTime - startTime).getSeconds() + " 秒.");
	}
}
