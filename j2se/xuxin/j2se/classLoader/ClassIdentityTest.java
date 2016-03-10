package xuxin.j2se.classLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
 * 测试不同类加载器加载的同一类是否兼容
 * 预期：出现类型转换错误
 * 分析：不同的类加载器加载同一个类生成的对象不兼容
 * 注意：需要将xJava.lang.base.Sample.java先删除，否则父类会优先加载这里的Sample.java
 * */
public class ClassIdentityTest {
	public static void main(String[] args) {
		System.out.println("=当前类加载器=" + ClassIdentityTest.class.getClassLoader());
		//第一次classPath写的是D:\\src没出现预期错误，因为类加载器是代理实现的，先
		//交给父类加载器处理，如果父类加载器处理不了再尝试自己处理。如果classPath写
		//成D:\\src的话，FileSystemClassLoader将加载类xuxin.lang.test.classLoad-
		//-erTest.Sample先交给父类加载器处理(这里父类加载器的classPath就是D:\\src
		//所以父类加载器直接在src下找到该class文件并加载进来，而不是交给自定义的
		//FileSystemClassLoader来处理。这里写成D:\\mycode\\classes(注：classes)
		//不在父类加载器的classPath路径范围，所以父类加载器处理不了，只能交由自定
		//义的FileSystemClassLoader来加载)
		String classPath = "D:\\mycode\\classes";
		FileSystemClassLoader f1 = new FileSystemClassLoader(classPath);
		FileSystemClassLoader f2 = new FileSystemClassLoader(classPath);
		try {
			Class class1 = f1.loadClass("xJava.lang.base.Sample");
			Class class2 = f2.loadClass("xJava.lang.base.Sample");
			Object obj1 = class1.newInstance();
			Object obj2 = class2.newInstance();
			System.out.println("=obj1的类加载器=" + obj1.getClass().getClassLoader());
			System.out.println("=obj2的类加载器=" + obj2.getClass().getClassLoader());
			Method setSampleMethod = class1.getMethod("setSample", java.lang.Object.class);
			//setSampleMethod方法是将obj2转型成obj1,因为不是同一类加载器加载的，
			//所以出现ClassCastException异常
			setSampleMethod.invoke(obj1, obj2);
			System.out.println("=========END=========");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
