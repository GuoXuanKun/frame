package com.gmgx.dao;

import com.gmgx.entity.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IStudentDao2 {
    @Select("select * from  t_student where tno =#{tno}")
    public List<Student> queryStudentByTno(Integer tno);

}
