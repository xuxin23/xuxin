package xuxin.j2se.classLoader;

/**
 * 检查类加载的顺序
 * 父类静态代码块-子类静态代码块-父类构造函数-子类构造函数
 * 注意：如父类构造函数调用了方法，而该方法又被子类重写，则父类构造方法实际调用的是子类重写的方法
 * @author xuxin
 *
 */
public class ClassLoaderOrder {
	public static void main(String[] args) {
		Son son = new Son();
	}
}

class Father {
	static {
		System.out.println("Father的静态代码块");
	}
	public Father() {
		System.out.println("Father的构造函数");
		//注意：创建子类调用父类构造方法的时候，这里的speak执行的是子类重写的speak
		this.speak();
	}
	public void speak() {
		System.out.println("Father的speak()");
	}
}

class Son extends Father {
	static {
		System.out.println("Son的静态代码块");
	}
	public Son() {
		System.out.println("Son的构造函数");
		this.speak();
	}
	public void speak() {
		System.out.println("Son的speak()");
	}
}