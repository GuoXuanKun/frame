package com.gmgx.dao;

import com.gmgx.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IStudentDao {
    public List<Student> queryAllStudent();

    public Student queryStudentBySno(Integer sno);

    /**
     *
     * @param stu
     * @return
     */
    public boolean updateStudentAge(Student stu);

    /**
     * 用 模糊查询 查询学生
     * @param sname
     * @return
     */
    public List<Student> queryStudentByLikeSname(String sname);

    /**
     * 分页查询学生
     * @param startNum
     * @param pageSize
     * @return
     */
    public List<Student> queryStudentByPage(@Param("startNum") Integer startNum , @Param("pageSize") Integer pageSize);

    /**
     * 查询学生 排序
     * @param colName
     * @param orderType
     * @return
     */
    public List<Student> queryStudentByOrder(@Param("colName") String colName,@Param("orderType") String orderType);

    public List<Student> queryAllStudentByAge(@Param("hightAge")Integer hightAge,@Param("lowAge")Integer lowAge);
}
