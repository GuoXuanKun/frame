package com.gmgx.dao;


import com.gmgx.entity.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITeacherDao {

    @Select("select tno,tname,sex from t_teacher")
    public List<Teacher> queryAllTeacher();


    @Select("select tno,tname,sex from t_teacher where tno  =#{tno}")
    public List<Teacher> queryTeacherByTno(Integer tno);

    @Insert("  insert into t_teacher(tname,sex)values(#{tname},#{sex})    ")

    public boolean addTeacher(Teacher teacher);






}
