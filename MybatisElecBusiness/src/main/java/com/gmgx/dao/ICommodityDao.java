package com.gmgx.dao;

import com.gmgx.entity.Commodity;

import java.util.List;

public interface ICommodityDao {

    public List<Commodity> queryAllCommodityByCommodityName(String commodityName);
}
