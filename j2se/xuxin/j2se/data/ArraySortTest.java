package xuxin.j2se.data;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class ArraySortTest {

	private static int[] source;
	
	@Before
	public void init() {
		source = new int[]{5,7,1,3,8,9,2,4,6};
		System.out.println("初始化source:\t" + Arrays.toString(source));
	}
	
	// 冒泡排序测试
	@Test
	public void boobleSort() {
		source = ArraySort.bubbleSort(source);
		System.out.println("冒泡排序：\t" + Arrays.toString(source));
	}
	
	// 选择排序测试
	@Test
	public void selectedSort() {
		source = ArraySort.selectedSort(source);
		System.out.println("选择排序：\t" + Arrays.toString(source));
	}
	
	// 插入排序测试
	@Test
	public void insertSort() {
		source = ArraySort.insertSort(source);
		System.out.println("插入排序：\t" + Arrays.toString(source));
	}
}
