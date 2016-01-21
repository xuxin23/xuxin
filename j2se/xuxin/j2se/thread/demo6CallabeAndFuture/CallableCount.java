package xuxin.j2se.thread.demo6CallabeAndFuture;

import java.util.concurrent.Callable;

/**
 * 模拟线程
 * @author xuxin
 * @date 2013-7-15
 */
public class CallableCount implements Callable<Integer>{

	private int baseNum;
	
	public CallableCount(int num) {
		this.baseNum = num;
	}
	
	public Integer call() throws Exception {
		Thread.sleep(5000);
		return baseNum * 100 + 1314;
	}

}
