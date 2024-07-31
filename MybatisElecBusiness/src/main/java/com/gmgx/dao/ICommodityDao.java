package com.gmgx.dao;

import com.gmgx.entity.Commodity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICommodityDao {

    /**
     * 根据商品名称查询商品
     * @param commodityName
     * @return
     */
    public List<Commodity> queryAllCommodityByCommodityName(String commodityName);

    /**
     * 查询商品 选择 排序
     * @param choose
     * @param way
     * @return
     */
    public List<Commodity> queryAllCommodityByChoose(@Param("choose") String choose,@Param("way") String way);
}
