/**
 * 
 */
package xuxin.j2se.jdbc.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xuxin.j2se.jdbc.dao.TeacherDAO;
import xuxin.j2se.jdbc.domain.Teacher;

/**
 * 教师DaoImpl
 * @version 1.0
 * @author xuxin 
 * @data 2012-12-22
 */
public class TeacherDaoImpl extends AbstractDaoImpl implements TeacherDAO{

    //以下是jdbc_teacher的增删改查用到的sql模板语句
    private String findById = "select * from jdbc_teacher where tea_id = ?";
    private String findAll = "select * from jdbc_teacher";
    private String doAdd = "insert into jdbc_teacher(tea_id,tea_name,tea_sex,tea_address," +
    		               "tea_age,tea_level,tea_others,tea_more) values(?,?,?,?,?,?,?,?)";
    private String doUpdate = "update jdbc_teacher set tea_name=?,tea_sex=?,tea_address=?," +
    		                "tea_age=?,tea_level=?,tea_others=?,tea_more=? where " +
    		                "tea_id=?";
    private String doDelete = "delete from jdbc_teacher where tea_id=?";
    
    //通过id查询教师
    public Teacher findById(String teacherId) {
        Object[] objs = {teacherId};
        return (Teacher) super.findById(findById, objs);
    }

    //查询全部教师信息
    public ArrayList<Teacher> findAll() {
        Object[] objs = {};
        List oldList = super.findAll(findAll, objs);
        ArrayList<Teacher> newList = new ArrayList<Teacher>();
        for (Object obj:oldList) {
            newList.add((Teacher)obj);
        }
        return newList;
    }

    //添加教师信息
    public int doAdd(Teacher teacher) {
        Object[] objs = {teacher.getTeacherId(),
                         teacher.getTeacherName(),
                         teacher.getTeacherSex(),
                         teacher.getTeacherAddress(),
                         teacher.getTeacherAge(),
                         teacher.getTeacherLevel(),
                         teacher.getTeacherOthers(),
                         teacher.getTeacherMore()};
        return super.doUpdate(doAdd, objs);
    }

    //更新教师信息
    public int doUpdate(Teacher teacher) {
        Object[] objs = {teacher.getTeacherName(),
                         teacher.getTeacherSex(),
                         teacher.getTeacherAddress(),
                         teacher.getTeacherAge(),
                         teacher.getTeacherLevel(),
                         teacher.getTeacherOthers(),
                         teacher.getTeacherMore(),
                         teacher.getTeacherId()};
        return super.doUpdate(doUpdate, objs);
    }

    //删除教师信息
    public int doDelete(String teacherId) {
        Object[] objs = {teacherId};
        return super.doUpdate(doDelete, objs);
    }

    //模板方法模式
    @Override
    public Object Wrap(ResultSet rs) throws SQLException {
        Teacher tea = new Teacher();
        tea.setTeacherId(rs.getString(1));
        tea.setTeacherName(rs.getString(2));
        tea.setTeacherSex(rs.getString(3));
        tea.setTeacherAddress(rs.getString(4));
        tea.setTeacherAge(rs.getString(5));
        tea.setTeacherLevel(rs.getString(6));
        tea.setTeacherOthers(rs.getString(7));
        tea.setTeacherMore(rs.getString(8));
        return tea;
    }

    /*public static void main(String[] args) {
        
        TeacherDAO dao = new TeacherDaoImpl();
        
        //查询教师
        System.out.println(dao.findById("101").getTeacherName());
        
        //添加教师
        Teacher tea = new Teacher();
        tea.setTeacherId("102");
        tea.setTeacherAddress("山东烟台");
        tea.setTeacherAge("23");
        tea.setTeacherLevel("研究生");
        tea.setTeacherSex("女");
        tea.setTeacherName("小苓");
        dao.doAdd(tea);
        
        //修改教师
        tea.setTeacherAddress("安徽桐城");
        dao.doUpdate(tea);
        
        //删除教师
        dao.doDelete("102");
    }*/
}
