package com.xenon.service.impl;

import com.xenon.entity.Orders;
import com.xenon.mapper.OrdersMapper;
import com.xenon.service.OrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author wuyunbin
 * @since 2024-09-01
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

}
