package xuxin.j2se.thread.demo0ThreadLocal;

public class Client {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Job(), "thread-1");
		Thread t2 = new Thread(new Job(), "thread-2");
		t1.start();
		t2.start();
	}
}
