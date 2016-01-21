package xuxin.j2se.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

//从虚拟机的角度考虑，就非常理所当然了
public class ReflectMethodDemo {
	
	public static void main(String[] args) throws ClassNotFoundException {
//		Class<?> c = Class.forName("java.lang.reflect.Method");
		Class<?> c = Class.forName("xJava.proxy.Dog");
		
		//得到接口Class数组
		Class[] interfaces = c.getInterfaces();
		System.out.println("--------------接口如下-----------------");
		for (Class e:interfaces) {
			System.out.println("接口名：" + e.getSimpleName() + "\t类型：" + e);
		}
		
		//得到父类的Class对象
		System.out.println("--------------父类如下-----------------");
		System.out.println("类型" + c.getSuperclass());
		
		//得到字段信息
		Field[] fields = c.getDeclaredFields();
		System.out.println("--------------字段如下-----------------");
		for (Field e:fields) {
			System.out.println("字段名:" + e.getName() + "\t类型：" + e.getClass() + 
					"\t访问权限：" + e.getModifiers());
		}
		
		//得到方法信息
		Method[] methods = c.getDeclaredMethods();
		System.out.println("--------------方法如下-----------------");
		for (Method e:methods) {
			System.out.println("方法名：" + e.getName() + "\t返回值类型：" + e.getReturnType() + 
					"\t访问权限：" + e.getModifiers() + "\t参数类型数组：" + Arrays.toString(e.getParameterTypes()) );
		}
		
		//得到构造方法信息
		Constructor[] constructors = c.getDeclaredConstructors();
		System.out.println("--------------构造方法如下-----------------");
		for (Constructor e:constructors) {
			System.out.println("构造方法参数类型数组：" + Arrays.deepToString(e.getParameterTypes()) + 
					"\t访问权限：" + e.getModifiers());
		}
		
		//方法调用
//		try {
//			Method m = c.getMethod("shout", null);
//			m.invoke(new xJava.lang.proxy._Dog2(), null);
//		} catch (SecurityException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (NoSuchMethodException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
	}
}
