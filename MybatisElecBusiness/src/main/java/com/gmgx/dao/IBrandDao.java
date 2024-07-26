package com.gmgx.dao;

import com.gmgx.entity.Brand;

import java.util.List;

/**
 * 查询所有品牌
 */
public interface IBrandDao {
    public List<Brand> queryAllBrand();
}
