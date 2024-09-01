package com.xenon.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author wuyunbin
 * @since 2024-09-01
 */
@Getter
@Setter
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键-订单号
     */
    private String id;

    /**
     * 订单状态 1待付款，2待派送，3已派送，4已完成，5已取消
     */
    private Integer status;

    /**
     * 下单用户
     */
    private String memberId;

    /**
     * 地址id
     */
    private String addressBookId;

    /**
     * 下单时间
     */
    private Date orderTime;

    /**
     * 结账时间
     */
    private Date checkoutTime;

    /**
     * 支付方式 1微信,2支付宝
     */
    private Integer payMethod;

    /**
     * 实收金额
     */
    private BigDecimal amount;

    /**
     * 备注
     */
    private String remark;

    /**
     * 收件人手机号
     */
    private String phone;

    /**
     * 收件地址
     */
    private String address;

    /**
     * 收货人姓名
     */
    private String consignee;
}
