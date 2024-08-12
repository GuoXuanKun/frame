package com.gmgx.dao;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface IUserDao {

  @Update("update t_user set user_money=user_money+#{money} where user_id=#{userid} ")
  public Boolean modifyMoney(@Param("userid") Integer userId, @Param("money") Double money);


}
