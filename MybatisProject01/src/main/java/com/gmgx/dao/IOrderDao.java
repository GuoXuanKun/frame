package com.gmgx.dao;

import com.gmgx.entity.Order;

import java.util.List;

public interface IOrderDao {
    public List<Order> queryAllOrderAndUser();

    public List<Order> queryOrderByUserId(Integer userId);

    public List<Order> queryAllOrderAndUser2();


}
