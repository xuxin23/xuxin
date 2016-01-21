package xuxin.j2se.base;

import java.util.ArrayList;

/**
 * 讨论Cloneable的实现：
 * 这里主要有3个问题：
 * 1.必须实现Cloneable接口，虽然Object有clone(),但JVM只识别实现了Cloneable接口的类。
 *   即使你使用自己的clone()都不行。。没办法，clone()的底层是由JVM实现的。。。
 * 2.深拷贝，对于引用类型的变量需要深拷贝才能实现我们一般需要的那种拷贝
 * 3.重写clone():   super.clone()复制当前调用该方法的对象，用到RTTI（运行时识别）
 * @author Administrator
 *
 */
public class CloneableTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		ArrayList list = new ArrayList();
		list.add(new Integer(1));
		
		Product p1 = new Product(250,list);
		System.out.println("p1:" + p1.getNum() + "-" + p1.getList());
		Product p2 = p1.clone();
		p2.setNum(251);
		//修改list的值，观察是否深拷贝：如果深拷贝，则改变原来的list不会影响复制的list
		list.add(new Integer(3));
		System.out.println("p2:" + p2.getNum() + "-" + p2.getList());
		System.out.println("p1:" + p1.getNum() + "-" + p1.getList());
	}
	
}

class Product implements Cloneable{
	public int num;
	public ArrayList list;
	public Product(int num,ArrayList list) {
		this.num = num;
		this.list = list;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public ArrayList getList() {
		return list;
	}

	public void setList(ArrayList list) {
		this.list = list;
	}

	//重写clone方法
	public Product clone() throws CloneNotSupportedException{
		Product product = null;
		product = (Product)super.clone();
		//深拷贝
		if (list != null) {
			product.list = (ArrayList) list.clone();
		}
		return product;
	}
}
