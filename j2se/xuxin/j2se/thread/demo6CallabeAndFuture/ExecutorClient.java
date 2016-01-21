package xuxin.j2se.thread.demo6CallabeAndFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 简单使用执行器
 * @author xuxin
 * @date 2013-7-15
 */
public class ExecutorClient {

	public static void main(String[] args) {
		// 获取一个线程池
		ExecutorService pool = Executors.newFixedThreadPool(20);
		
		// 使用线程池执行100个任务
		List<Future<Integer>> futureList = new ArrayList<Future<Integer>>();
		for (int i=10; i<100; i++) {
			futureList.add(pool.submit(new CallableCount(i))); 
		}
		
		// 关闭线程池（已经提交的任务会继续执行完）
		pool.shutdown();
		
		// 打印任务结果
		for (Future<Integer> future:futureList) {
			try {
				System.out.println(future.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		
	}
}
