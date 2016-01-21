
package xuxin.j2se.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * 批操作
 * @author xuxin
 * @date 2013-7-17
 */
public class BatOperation {

	/**
	 * 求两个集合的并集
	 */
	@Test
	public void testRetainAll() {
		
		List<String> la = new ArrayList<String>();
		la.add("java");
		la.add("perl");
		la.add("python");
		la.add("c++");
		
		List<String> lb = new ArrayList<String>();
		lb.add("perl");
		lb.add("c++");
		lb.add("jquery");
		lb.add("extjs");
		
		// 存放la和lb的并集集合,添加la
		List<String> list = new ArrayList<String>(la);
		// 与lb并集
		list.retainAll(lb);
		
		System.out.println(list);
	}
	
	/**
	 * 删除集合部分元素
	 * 集合存放于Map中，
	 * 需要删除的键id存放于Set中
	 * 【注】 这种思路很好。获取map的set视图以set的方法来操作map,碉堡了！
	 */
	@Test
	public void testRemoveAll() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("01", "kobe");
		map.put("02", "james");
		map.put("03", "wade");
		map.put("04", "bosh");
		map.put("05", "paul");
		
		Set<String> set = new HashSet<String>();
		set.add("02");
		set.add("05");
		
		// 以map的keySet视图来删除,结果会反映到map中
		// 注意，如果是新增的话则会报异常，因为底层是map不能只增加key而没有value
		map.keySet().removeAll(set);
		System.out.println(map);
	}
	
	public static void main(String[] args) {
		System.out.println("hello world..");
		Map<String, String> map = new HashMap<String, String>();
		map.put("11", "apple");
		map.put("11", "pc");
	}
}
