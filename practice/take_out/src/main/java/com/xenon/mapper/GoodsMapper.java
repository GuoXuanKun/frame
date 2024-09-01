package com.xenon.mapper;

import com.xenon.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 商品管理 Mapper 接口
 * </p>
 *
 * @author wuyunbin
 * @since 2024-09-01
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {

}
