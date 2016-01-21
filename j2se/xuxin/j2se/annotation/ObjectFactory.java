package xuxin.j2se.annotation;

import java.lang.reflect.InvocationTargetException;

/**
 * 处理类，将需要的对象送入Frame进行初始化
 * 就是先将对象送到自定义Annotation处理的框架或工具，再返回
 * 如果让用户手动new对象，那么还得手动调用Frame.setDefault()以使得对象上的注解起到作用
 * 所以索性将对象的创建过程集中处理，用户创建一个对象只需向工厂传入一个字符串，工厂负责
 * 调用Frame.setDefault
 * ===关键：替用户创建对象，返回之前用反射获取注解信息并作相关处理
 * @author Administrator
 *
 */
public class ObjectFactory {
	
	private static Object obj;
	
	public static <T> T createObject(Class<T> clazz) throws InstantiationException, IllegalAccessException, IllegalArgumentException, SecurityException, InvocationTargetException, NoSuchMethodException {
		obj = clazz.newInstance();
		Frame.setDefault(obj);
		return (T)obj;
	}
}
