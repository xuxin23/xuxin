package xuxin.j2se.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

public class HashSetDemo {

	// 测试HashSet的无序
	@Test
	public void testWuxu() {
		
		String[] arr = {"1css", "2html", "3xml", "4javascript", "5java", "6perl", "7phyton", "8ruby", "9c"};
		Set<String> set = new HashSet<String>();
		for (int i=0; i<arr.length; i++) {
			set.add(arr[i]);
		}
		
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			// 打印的结果是无序的
			System.out.println(iterator.next());
		}
	}
}
