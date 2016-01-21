package xuxin.j2se.jdbc.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 用于获取数据库连接
 * @version 1.0
 * @author xuxin 
 * @data 2012-12-22
 */
public class ConnectionGetter {

    /**
     * 连接数据的基本信息
     */
    private static String driverName = "oracle.jdbc.driver.OracleDriver";
    private static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static String userName = "xuxin";
    private static String password = "xuxin";
    
    static {
        try {
            Class.forName(driverName);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 获取数据库连接
     * @return Connection
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, userName, password);
    }
    
    /*public static void main(String[] args) {
        try {
            System.out.println(getConnection());
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
}
