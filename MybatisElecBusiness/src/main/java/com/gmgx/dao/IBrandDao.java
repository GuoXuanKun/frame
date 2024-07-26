package com.gmgx.dao;

import com.gmgx.entity.Brand;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 多条件查询品牌名称
     * @param status
     * @param brandName
     * @param companyName
     * @return
     */
    public Brand queruBrandByMultipleConditions(@Param("status") int status , @Param("brandName") String brandName,@Param("companyName") String companyName);

    /**
     * 插入品牌
     * @param brand
     * @return
     */
    public Boolean insertBrand(Brand brand);
}
