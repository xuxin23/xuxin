package xuxin.j2se.proxy;

import java.lang.reflect.Proxy;

/**
 * 动态代理应用场景
 * @version 1.0
 * @author xuxin
 */
public class Client {
    
    public static void main(String[] args) {
        Dog dog = new Dog();
        Class clazz = dog.getClass();
        
        IDog proxy = (IDog) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new DogInvocationHandler(dog));
        proxy.shout();
    }
}
