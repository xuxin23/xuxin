package xuxin.j2se.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * 集合和数组的转换
 * @author xuxin
 * @date 2013-7-17
 */
public class ArrayAndCollection {

	/**
	 * 数组转换为集合
	 */
	@Test
	public void testArrayToCollection() {
		String[] arr = {"kobe", "james", "wade", "paul"};
		// 这里的list不是视图，而是将视图的内容填充进来的ArrayList，所以可以进行改变大小的操作
		List<String> list = new ArrayList<String>(Arrays.asList(arr));
		list.add("太空易");
		System.out.println(list);
	}
	
	/**
	 * 集合转换为数组
	 */
	@Test
	public void testCollectionToArray() {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		
		// List.toArray()返回的是Object[]数组，而List.toArray(T[] t)就会返回指定类型的数组了
		String[] arr = list.toArray(new String[0]);
		System.out.println(Arrays.toString(arr));
		
	}
}
