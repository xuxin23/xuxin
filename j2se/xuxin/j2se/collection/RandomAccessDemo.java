package xuxin.j2se.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.RandomAccess;

import org.junit.Test;

/**
 * RandomAccess是一个标志接口，仅用来标志某集合是否支持高效的随机访问
 * @author xuxin
 * @date 2013-7-16
 */
public class RandomAccessDemo {

	// 测试一些集合是否支持高效的随机访问
	@Test
	public void testRandomAccess() {
		List a = new ArrayList();
		List b = new LinkedList();
		
		isRandomAccess(a);
		isRandomAccess(b);
	}
	
	private void isRandomAccess(List list) {
		if (list instanceof RandomAccess) {
			System.out.println(list.getClass().getName() + "支持高效的随机访问！");
		} else {
			System.out.println(list.getClass().getName() + "不支持高效的随机访问！");
		}
	}
}
