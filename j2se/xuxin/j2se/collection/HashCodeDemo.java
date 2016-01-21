package xuxin.j2se.collection;

/**
 * HashSet中存储的对象最好重写hashCode()方法，提升对象比较效率
 * @author Administrator
 *
 */
public class HashCodeDemo {
	
	//该对象的属性
	public int num;
	
	public int getNum() {
		return this.num;
	}
	
	//构造
	public HashCodeDemo(int num) {
		this.num = num;
	}
	
	//重写equals
	//首先比较地址，对象地址一样一定是同一个对象
	//其次，根据实际情况比较对象的属性是否相等(需要转换为同一对象)
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj != null && obj.getClass() == HashCodeDemo.class) {
			HashCodeDemo demo = (HashCodeDemo) obj;
			return this.getNum() == demo.getNum();
		}
		return false;
	}
	
	//重写hashCode
	public int hashCode() {
		int result = 17;
		result = 31 * result + this.num;
		return result;
	}
	
}
