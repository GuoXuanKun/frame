package com.xenon.mapper;

import com.xenon.entity.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author wuyunbin
 * @since 2024-09-01
 */
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {

}
