package xuxin.j2se.jdbc.tool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库连接池
 * @version 1.0
 * @author xuxin 
 * @data 2012-12-22
 */
public class ConnectionPool {

    /**
     * 单例
     */
    private static ConnectionPool connectionPool;
    
    /**
     * 数据库连接集合
     */
    private static List<Connection> list;
    
    /**
     * 私有构造函数，防止外部创建实例
     */
    private ConnectionPool() {
        
    };
    
    /**
     * 连接池初始化
     */
    static {
        list = new ArrayList<Connection>();
        for (int i=0;i<10;i++) {
            try {
                list.add(ConnectionGetter.getConnection());
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * 获取单例
     * @return
     */
    public static ConnectionPool getInstance() {
        if (connectionPool == null) {
            synchronized(ConnectionPool.class) {
                connectionPool = new ConnectionPool();
            }
        }
        return connectionPool;
    }
    
    /**
     * 获取连接池的数据库连接
     * @return
     */
    public Connection getConnection() {
        return list.remove(0);
    }
    
    /**
     * 回收数据库连接
     * @param conn
     */
    public void close(Connection conn) {
        list.add(conn);
    }
}
