package com.gmgx.util;

import org.springframework.stereotype.Component;

@Component
public class JDBCUtils {

    public boolean login(String username,String password){

        if("zhw".equals(username)&&"123".equals(password)){
            return true;
        }
        return false;

    }


    public JDBCUtils() {

        System.out.println("JDBCUtils的无参构造");

    }
}
