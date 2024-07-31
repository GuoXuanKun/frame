package com.gmgx.dao;

import com.gmgx.entity.Commodity;

import java.util.List;

public interface ICommodityDao {

    /**
     * 根据商品名称查询商品
     * @param commodityName
     * @return
     */
    public List<Commodity> queryAllCommodityByCommodityName(String commodityName);
}
