package xuxin.j2se.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * 视图测试
 * @author xuxin
 * @date 2013-7-17
 */
public class ListView {

	@Test
	public void testAsList() {
		String[] arr = {"java", "python", "perl", "c#"};
		// 返回的不是一个List，而是一个视图对象，可以使用set/get来访问底层的数组
		List list = Arrays.asList(arr);
		
		System.out.println(list.get(2));
		list.set(2, "perl2");
		System.out.println(list.get(2));
		// 对视图的修改也反映到底层的数组
		System.out.println(Arrays.toString(arr));
		
		// 改变视图大小会报异常 java.lang.UnsupportedOperationException
		// 因为底层是数组，而数组的大小不允许改变
		list.add("php");
	}
	
	@Test
	public void testSubList() {
		List<String> list = new ArrayList<String>();
		list.add("java");
		list.add("python");
		list.add("perl");
		list.add("c#");
		
		// 返回list的子视图subList
		List<String> subList = list.subList(0, 2);
		System.out.println(subList);
		
		// 对子视图subList修改会反映到原List
		// 注意，和上面的测试不同，这里可以改变视图的大小，因为底层是集合而不是数组
		subList.add("php");
		System.out.println(list);
	}
	
}
