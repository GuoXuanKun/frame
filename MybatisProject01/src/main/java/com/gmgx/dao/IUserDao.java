package com.gmgx.dao;

import com.gmgx.entity.User;

import java.nio.file.attribute.UserPrincipal;
import java.util.List;

public interface IUserDao {
    public List<User> queryUserByLikeName(String userName);
}
