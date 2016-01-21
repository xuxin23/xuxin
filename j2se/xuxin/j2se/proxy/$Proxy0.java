package xuxin.j2se.proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * 动态代理生成的代理类实例$Proxy0
 * 可以看出，$Proxy0就是一个和被代理类实现同一个接口(proxy前2个参数)，它的方法的实现都是通过
 * 调用传入的InvocationHandler来间接调用被代理类的方法的。
 * @version 1.0
 * @author xuxin
 */
public final class $Proxy0 extends Proxy implements Manager {

private static Method m1;
private static Method m0;
private static Method m3;
private static Method m2;

static {
   try {
    m1 = Class.forName("java.lang.Object").getMethod("equals",
      new Class[] { Class.forName("java.lang.Object") });
    m0 = Class.forName("java.lang.Object").getMethod("hashCode",
      new Class[0]);
    m3 = Class.forName("com.ml.test.Manager").getMethod("modify",
      new Class[0]);
    m2 = Class.forName("java.lang.Object").getMethod("toString",
      new Class[0]);
   } catch (NoSuchMethodException nosuchmethodexception) {
    throw new NoSuchMethodError(nosuchmethodexception.getMessage());
   } catch (ClassNotFoundException classnotfoundexception) {
    throw new NoClassDefFoundError(classnotfoundexception.getMessage());
   }
}

public $Proxy0(InvocationHandler invocationhandler) {
   super(invocationhandler);
}

@Override
public final boolean equals(Object obj) {
   try {
    return ((Boolean) super.h.invoke(this, m1, new Object[] { obj }))
      .booleanValue();
   } catch (Throwable throwable) {
    throw new UndeclaredThrowableException(throwable);
   }
}

@Override
public final int hashCode() {
   try {
    return ((Integer) super.h.invoke(this, m0, null)).intValue();
   } catch (Throwable throwable) {
    throw new UndeclaredThrowableException(throwable);
   }
}

public final void modify() {
   try {
    super.h.invoke(this, m3, null);
    return;
   } catch (Error e) {
   } catch (Throwable throwable) {
    throw new UndeclaredThrowableException(throwable);
   }
}

@Override
public final String toString() {
   try {
    return (String) super.h.invoke(this, m2, null);
   } catch (Throwable throwable) {
    throw new UndeclaredThrowableException(throwable);
   }
}
}

