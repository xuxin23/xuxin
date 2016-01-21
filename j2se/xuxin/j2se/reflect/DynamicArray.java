package xuxin.j2se.reflect;

import java.lang.reflect.Array;

/**
 * 用反射实现动态数组
 * @author Administrator
 *
 */
public class DynamicArray {

	public static Object add(Object obj) {
		Class cl = obj.getClass();
		//如果不是数组，返回null
		if (!cl.isArray()) {
			return null;
		}
		Class componentType = cl.getComponentType();
		int length = Array.getLength(obj);
		Object newObj = Array.newInstance(componentType, length + 5);
		return newObj;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[10];
		System.out.println("old_length:" + arr.length);
		
		arr = (int[])DynamicArray.add(arr);
		System.out.println("new_length:" + arr.length);
	}
}
