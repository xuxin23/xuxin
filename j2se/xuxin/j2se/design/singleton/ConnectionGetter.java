/**
 * 
 */
package xuxin.j2se.design.singleton;

import java.sql.Connection;

/**
 * 单例模式：模拟数据库连接管理类的单例实现
 * @version 1.0
 * @author xuxin 
 * @data 2012-12-31
 */
public class ConnectionGetter {

    /**
     * 定义一个静态的单例对象，采用懒汉模式
     */
    private static ConnectionGetter connectionGetter;
    
    /**
     * 定义private权限的构造函数，防止实例化更多的对象
     */
    private ConnectionGetter() {
        //nothing
    }
    
    /**
     * 获取单例的静态方法
     */
    public static ConnectionGetter getInstance() {
        if (connectionGetter == null) {
            synchronized(ConnectionGetter.class) {
                connectionGetter = new ConnectionGetter();
            }
        }
        return connectionGetter;
    }
    
    /**
     * 获取连接
     */
    public Connection getConnection() {
        //TODO
        return null;
    }
}
