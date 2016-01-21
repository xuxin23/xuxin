/**
 * 
 */
package xuxin.j2se.jdbc.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import xuxin.j2se.jdbc.dao.StudentDAO;
import xuxin.j2se.jdbc.domain.Student;

/**
 * 学生DaoImpl
 * @version 1.0
 * @author xuxin 
 * @data 2012-12-22
 */
public class StudentDaoImpl extends AbstractDaoImpl implements StudentDAO{

    //以下是jdbc_student的增删改查用到的sql模板语句
    private String findById = "select * from jdbc_student where stu_id = ?";
    private String findAll = "select * from jdbc_student";
    private String doAdd = "insert into jdbc_student(stu_id,stu_name,stu_age," + 
                            "stu_sex,stu_phoneno,stu_address,stu_point,stu_others," +
                            "stu_more) values (?,?,?,?,?,?,?,?,?)";
    private String doUpdate = "update jdbc_student set stu_name=?,stu_age=?,stu_sex=?," +
    		                "stu_phoneno=?,stu_address=?,stu_point=?,stu_others=?," +
    		                "stu_more=? where stu_id = ?";
    private String doDelete = "delete from jdbc_student where stu_id = ?";
    
    //通过学生id查找
    public Student findById(String studentId) {
        Object[] objs = {studentId};
        return (Student) super.findById(findById, objs);
    }

    //查找全部
    public ArrayList<Student> findAll() {
        Object[] objs = {};
        List oldList = super.findAll(findAll, objs);
        ArrayList<Student> newList = new ArrayList<Student>();
        for (Object obj:oldList) {
            Student stu = (Student) obj;
            newList.add(stu);
        }
        return newList;
    }

    //添加学生信息
    public int doAdd(Student student) {
        Object[] objs = {student.getStudentId(),
                         student.getStudentName(),
                         student.getStudentAge(),
                         student.getStudentSex(),
                         student.getStudentPhoneNo(),
                         student.getStudentAddress(),
                         student.getStudentPoint(),
                         student.getStudentOthers(),
                         student.getStudentMore()};
        System.out.println(Arrays.toString(objs));
        return super.doUpdate(doAdd, objs);
    }

    //更新学生信息
    public int doUpdate(Student student) {
        Object[] objs = {student.getStudentName(),
                student.getStudentAge(),
                student.getStudentSex(),
                student.getStudentPhoneNo(),
                student.getStudentAddress(),
                student.getStudentPoint(),
                student.getStudentOthers(),
                student.getStudentMore(),
                student.getStudentId()};
        return super.doUpdate(doUpdate, objs);
    }

    //删除学生信息
    public int doDelete(String studentId) {
        Object[] objs = {studentId};
        return super.doUpdate(doDelete, objs);
    }

    //模板方法模式
    public Object Wrap(ResultSet rs) throws SQLException {
        Student student = new Student();
        student.setStudentId(rs.getString(1));
        student.setStudentName(rs.getString(2));
        student.setStudentAge(rs.getString(3));
        student.setStudentSex(rs.getString(4));
        student.setStudentPhoneNo(rs.getString(5));
        student.setStudentAddress(rs.getString(6));
        student.setStudentPoint(rs.getString(7));
        student.setStudentOthers(rs.getString(8));
        student.setStudentMore(rs.getString(9));
        return student;
    }

    /*public static void main(String[] args) {
        
        StudentDAO dao = new StudentDaoImpl();
        
        //查找学生
        Student student = dao.findById("1001");
        System.out.println(student.getStudentName());
        
        //新增学生
        Student stu = new Student();
        stu.setStudentId("1003");
        stu.setStudentName("小王");
        stu.setStudentAge("23");
        stu.setStudentAddress("上海浦东区");
        stu.setStudentPhoneNo("13099882355");
        stu.setStudentPoint("问题学生");
        stu.setStudentSex("男");
        dao.doAdd(stu);
        
        //修改学生
        stu.setStudentName("测试修改");
        dao.doUpdate(stu);
        
        //删除学生
        dao.doDelete("1002");
    }*/
}
