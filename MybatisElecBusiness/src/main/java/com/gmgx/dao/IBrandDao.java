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
     * 根据 品牌 id 查询品牌描述 用 ${}
     * @param id
     * @return
     */
    public String queryDescription02(int id);

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

    /**
     * 根据 品牌id 删除品牌
     * @param id
     * @return
     */
    public Boolean deleteBrand(int id);

    /**
     * 根据 品牌id 更新品牌
     * @param brand
     * @return
     */
    public Boolean updateBrand(Brand brand);

    /**
     * 根据选择 查询品牌
     * @param choose
     * @param field
     * @return
     */
    public List<Brand> queryBrandByChoose(@Param("choose") String choose ,@Param("field") String field);

    /**
     * 根据 品牌id 更新 有更改字段的品牌
     * @param brand
     * @return
     */
    public Boolean updateBrandByFieldChange(Brand brand);

    /**
     * 根据 品牌id 集合 删除 品牌
     * @param idList
     * @return
     */
    public Boolean DeleteBrandBYIdList(@Param("idList") List idList);
}
