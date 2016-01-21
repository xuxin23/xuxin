package xuxin.j2se.thread.demo6CallabeAndFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * FutureTask包装器是一种很方便地将Callable转换成Future和Runnable的机制，它同时实现了两者的接口。
 * @author xuxin
 * @date 2013-7-15
 */
public class FutureTaskClient {

	public static void main(String[] args) {
		
		CallableCount count = new CallableCount(24);
		FutureTask<Integer> task = new FutureTask<Integer>(count);
		
		Thread t = new Thread(task);
		t.start();
		
		try {
			System.out.println(task.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
