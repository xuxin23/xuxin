/**
 * 
 */
package xuxin.j2se.jdbc.dao;

import java.util.ArrayList;

import xuxin.j2se.jdbc.domain.Teacher;

/**
 * 教师DAO
 * @version 1.0
 * @author xuxin 
 * @data 2012-12-22
 */
public interface TeacherDAO {

    /*通过id获取教师对象*/
    public Teacher findById(String teacherId);
    
    /*获取所有教师的集合*/
    public ArrayList<Teacher> findAll();
    
    /*添加教师信息*/
    public int doAdd(Teacher teacher);
    
    /*更新教师信息*/
    public int doUpdate(Teacher teacher);
    
    /*删除教师信息*/
    public int doDelete(String teacherId);
}
