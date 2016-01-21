/**
 * 
 */
package xuxin.j2se.jdbc.dao;

import java.util.ArrayList;

import xuxin.j2se.jdbc.domain.Student;

/**
 * @version 1.0
 * @author xuxin 
 * @data 2012-12-22
 */
public interface StudentDAO {

    /*通过id查找学生对象*/
    public Student findById(String studentId);
    
    /*查找全部学生对象*/
    public ArrayList<Student> findAll();
    
    /*添加学生信息*/
    public int doAdd(Student student);
    
    /*更新学生信息*/
    public int doUpdate(Student student);
    
    /*删除学生信息*/
    public int doDelete(String studentId);
}
