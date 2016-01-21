package xuxin.j2se.classLoader;

/*
 * 输出类加载器的结构
 * bootstrap class loader没有输出，这是虚拟机内部做了特殊处理
 * */
public class ClassLoaderTree {
	public static void main(String[] args) {
		ClassLoader loader = ClassLoaderTree.class.getClassLoader();
		while (loader != null) {
			System.out.println(loader.toString());
			//getParent()得到当前类加载器的父类加载器
			loader = loader.getParent();
		}
	}
}
