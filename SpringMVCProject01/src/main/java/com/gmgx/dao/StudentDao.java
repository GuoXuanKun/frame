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




}
