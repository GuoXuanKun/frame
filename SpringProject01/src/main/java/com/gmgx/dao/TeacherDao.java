package com.gmgx.dao;

import com.gmgx.util.JDBCUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class TeacherDao {

    /* 自动注入 */
    @Resource
    private JDBCUtils jdbcUtils;

    public TeacherDao() {
        System.out.println("TeacherDao的无参构造");
    }

    public boolean login(String username, String password){
        return jdbcUtils.login(username,password);

    }


}
