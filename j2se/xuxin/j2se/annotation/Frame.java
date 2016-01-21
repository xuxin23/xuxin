package xuxin.j2se.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 * 对自定义Annotation进行处理(反射)
 * @author Administrator
 *
 */
public class Frame {
	public static void setDefault(Object obj) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException {
		for (Method m:obj.getClass().getMethods()) {
			if (m.isAnnotationPresent(DefaultAnnotation.class)) {
				DefaultAnnotation annotation = m.getAnnotation(DefaultAnnotation.class);
				String getMethodName = m.getName();
				String setMethodName = getMethodName.replace("get", "set");
				if (m.getReturnType() == int.class) {
					Method setMethod = obj.getClass().getMethod(setMethodName, int.class);
					setMethod.invoke(obj, annotation.getInt());
				}else if (m.getReturnType() == String.class) {
					Method setMethod = obj.getClass().getMethod(setMethodName, java.lang.String.class);
					setMethod.invoke(obj, annotation.getString());
				}
			}
		}
	}
}
