package com.gmgx.dao;


import com.gmgx.entity.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ITeacherDao {

    @Select("select tno,tname,sex from t_teacher")
    public List<Teacher> queryAllTeacher();


    @Select("select tno,tname,sex from t_teacher where tno  =#{tno}")
    public List<Teacher> queryTeacherByTno(Integer tno);

    @Insert("  insert into t_teacher(tname,sex)values(#{tname},#{sex})    ")

    public boolean addTeacher(Teacher teacher);

    @Delete(" delete from t_teacher where tno=#{tno}  ")
    public  boolean deleteTeacher(Integer tno);

    @Update(" update t_teacher set tname =#{tname} where tno  =#{tno} ")
    public  boolean modifyTeacher(@Param("tno")Integer tno,@Param("tname")String tname);




    // 一对多的配置
    @Select("  select tno,tname,sex  from t_teacher where tno  =#{tno}  ")
    @Results({
            @Result(id = true,property = "tno",column = "tno"),
            @Result(property = "tname",column = "tname"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "myStuList" ,column = "tno",  // javaType = List.class,
                    many = @Many(select = "com.gmgx.dao.IStudentDao2.queryStudentByTno")
            )
    })
    public Teacher queryTeacherAndStudentsByTno(Integer tno);


    @Select(" select tno,tname,sex,cno mycno  from t_teacher where tno  =#{tno}  ")
    @Results({
            @Result(id = true,property = "tno",column = "tno"),// 主键:(一定要写)，其他键如果列名和属性名一致，可以不写
            @Result(property = "myClassroom" ,column = "mycno",// javaType = Classroom.class,可以省略
                    one = @One(select = "com.gmgx.dao.IClassroomDao.queryClassroomByCno")// 一对一的配置
            )

    })
    public Teacher queryTeacherAndClassroomByTno(Integer tno);



}
