package com.gmgx.dao;

import com.gmgx.entity.Student;
import com.gmgx.util.JDBCUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDao {

@Autowired
private JDBCUtils jdbcUtils;

public List<Student> queryAllStudent(){
  List<Student> list  = new ArrayList<>();

    ResultSet rs  = jdbcUtils.doQuery("select sno,sname,password from t_student");
   try {
       while (rs.next()){
           Student student  =     new Student();
           student.setSno(rs.getInt("sno"));
           student.setSname(rs.getString("sname"));
           student.setPassword(rs.getString("password"));
            list.add(student);
       }



   }catch (Exception e){
       e.printStackTrace();
   }finally {
       jdbcUtils.doClose(rs);
   }
    return  list;
}


    /**
     * 学生注册
     * @param student
     * @return
     */
    public boolean register(Student student){
        List<Student> list  = new ArrayList<>();

        String sql   ="insert into t_student(sname,password)values(?,?)";
        int newSno  = jdbcUtils.doAddObject(sql,student.getSname(),student.getPassword());

        student.setSno(newSno);

        return newSno>0;

    }



    public boolean deleteStudent(Integer sno){

        String sql   ="delete from t_student where sno  =?";
        int count  = jdbcUtils.doUpdate(sql,sno);

        return count>0;

    }





    public Student queryStudentBySno(Integer sno){
        Student student =null;

        ResultSet rs  = jdbcUtils.doQuery("select sno,sname,password from t_student where sno=?",sno);
        try {
            while (rs.next()){
                student  =     new Student();
                student.setSno(rs.getInt("sno"));
                student.setSname(rs.getString("sname"));
                student.setPassword(rs.getString("password"));

            }



        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jdbcUtils.doClose(rs);
        }
        return  student;
    }

    public boolean modifyStudent(Student student){

        String sql   ="update t_student set sname = ? ,password =? where sno  =?";
        int count  = jdbcUtils.doUpdate(sql,student.getSname(),student.getPassword(),student.getSno());

        return count>0;

    }


}
