package com.xenon.mapper;

import com.xenon.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 商品及套餐分类 Mapper 接口
 * </p>
 *
 * @author wuyunbin
 * @since 2024-09-01
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}
