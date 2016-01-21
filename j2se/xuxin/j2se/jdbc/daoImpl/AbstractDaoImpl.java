/**
 * 
 */
package xuxin.j2se.jdbc.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xuxin.j2se.jdbc.tool.ConnectionPool;

/**
 * DaoImpl抽象类
 * @version 1.0
 * @author xuxin 
 * @data 2012-12-22
 */
public abstract class AbstractDaoImpl {

    /*
     * 更新、删除、添加操作的公共方法体
     */
    public int doUpdate(String sql,Object[] objs) {
        Connection conn = ConnectionPool.getInstance().getConnection();
        int retValue = -1;
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            for (int i=0; i<objs.length; i++) {
                pstm.setObject(i+1, objs[i]);
            }
            retValue = pstm.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return retValue;
    }
    
    /*
     * 查找当个对象的公共方法体
     */
    public Object findById(String sql,Object[] objs) {
        Connection conn = ConnectionPool.getInstance().getConnection();
        Object retObj = null;
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            for (int i=0; i<objs.length; i++) {
                pstm.setObject(i+1, objs[i]);
            }
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                retObj = this.Wrap(rs);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return retObj;
    }
    
    /*
     * 查找全部对象的公共方法体
     */
    public List findAll(String sql,Object[] objs) {
        Connection conn = ConnectionPool.getInstance().getConnection();
        List list = new ArrayList();
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            for (int i=0; i<objs.length; i++) {
                pstm.setObject(i+1, objs[i]);
            }
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                list.add(this.Wrap(rs));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    /*
     * 抽象方法，将ResultSet包装成相应的子类对象
     */
    public abstract Object Wrap(ResultSet rs) throws SQLException;
}
