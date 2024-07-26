package com.gmgx.dao;

import com.gmgx.entity.Brand;

import java.util.List;


public interface IBrandDao {

    /**
     * 查询所有品牌
     */
    public List<Brand> queryAllBrand();

    /**
     * 根据 品牌 id 查询品牌描述
     * @param id
     * @return
     */
    public String queryDescription(int id);
}
