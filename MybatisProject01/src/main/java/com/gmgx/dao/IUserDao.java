package com.gmgx.dao;

import com.gmgx.entity.User;

import java.nio.file.attribute.UserPrincipal;
import java.util.List;

public interface IUserDao {

    public List<User> queryAllUser();

    public List<User> queryUserByLikeName(String userName);

    public List<User> queryAllUserAndOrder();

    /* 使用另外一种方式 实现 多表查询  一对多   */
    public List<User> queryAllUserAndOrder2();

    public User queryAllUserByUserId(Integer userId);

}
