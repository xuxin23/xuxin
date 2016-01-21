package xuxin.j2se.thread.demo0ThreadLocal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PrintInfo {

	private static Log logger = LogFactory.getLog(Job.class);
	
	public void test() {
		String threadName = Thread.currentThread().getName();
		logger.info(String.format("[%s] %s", threadName, Job.local.get()));
	}
}
