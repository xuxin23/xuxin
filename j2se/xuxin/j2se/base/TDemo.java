package xuxin.j2se.base;

import java.util.ArrayList;

/**
 * 验证泛型的特殊情况
 * String[]可以转换为Object[]；但ArrayList<String>不能转换为ArrayList<Object>
 * 泛型的引用就是为了明确类型的！！！
 * @author Administrator
 *
 */

public class TDemo {
	public static void main(String[] args) {
		//编译正常
		String[] str = {"hello","java"};
		Object[] obj = str;
		
		ArrayList<String> aList = new ArrayList<String>();
		aList.add("hello");
		aList.add("java");
		//下面的情况就会编译错误！
//		ArrayList<Object> oList = aList;
	}
}
