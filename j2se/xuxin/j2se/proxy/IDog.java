package xuxin.j2se.proxy;

/**
 * 动态代理辅助接口IDog
 * 动态代理需要被代理类实现对应的接口；Proxy在生成$proxy0的时候需要根据被代理类的接口来
 * 生成和被代理类同名的方法。
 * @version 1.2 20121201
 * @author xuxin
 *
 */
public interface IDog {
    
    public void shout();
}
