package xuxin.j2se.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 辅助类Dog的代理类的调用处理类
 * 在该类的Invoke方法中，在每个被代理类方法执行前后，可执行其他自定义操作，这就是代理的目的所在
 * 1.实现InvocationHanlder接口
 *      |-接口嘛，动态代理jdk已经有一套成熟的体系了，给出一个接口规范，遵循即可享受jdk的那套体系了，
 *        尼玛，就是动态代理了...Proxy/$proxy0/InvocationHandler...
 * 2.构造方法中，需要将被代理对象传递进来
 *      |-代理执行的就行被代理对象的方法，只是在执行的前后有一些操作而已
 * @version 1.2 20121201
 * @author xuxin
 *
 */
public class DogInvocationHandler implements InvocationHandler{

    private Object obj;
    public DogInvocationHandler(Object obj) {
        this.obj = obj;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置处理...");
        Object ret = method.invoke(obj, args);
        System.out.println("后置处理...");
        return ret;
    }
    
}
