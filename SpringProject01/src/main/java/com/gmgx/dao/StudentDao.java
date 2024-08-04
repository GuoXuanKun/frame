package com.gmgx.dao;


import com.gmgx.util.JDBCUtils;

public class StudentDao {


    private JDBCUtils jdbcUtils;

    /* 这个set方法是 给 普通写法使用，如果 纯 扫描+注解，不用写 */
    public void setJdbcUtils(JDBCUtils jdbcUtils) {
        this.jdbcUtils = jdbcUtils;
    }

    public StudentDao() {
        System.out.println("StudentDao的无参构造");
    }

    public boolean login(String username, String password){
        return jdbcUtils.login(username,password);

    }


}
