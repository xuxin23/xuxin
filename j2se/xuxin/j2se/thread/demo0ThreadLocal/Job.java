package xuxin.j2se.thread.demo0ThreadLocal;

public class Job implements Runnable{

	public static ThreadLocal<Integer> local = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			int retValue = (int) (Math.random() * 100000);
			System.out.println(retValue);
			return retValue;
		}
	};
	
	public void run() {
	System.out.println("------------------");
		for (int i=0; i<40; i++) {
			new PrintInfo().test();
		}
		
	}

}
