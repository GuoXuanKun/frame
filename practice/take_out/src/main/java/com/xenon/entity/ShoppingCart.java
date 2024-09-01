package com.xenon.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 购物车
 * </p>
 *
 * @author wuyunbin
 * @since 2024-09-01
 */
@Getter
@Setter
@TableName("shopping_cart")
public class ShoppingCart implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 图片
     */
    private String image;

    /**
     * 用户id
     */
    private String memberId;

    /**
     * 商品id
     */
    private String goodsId;

    /**
     * 套餐id
     */
    private Long setMealId;

    /**
     * 口味
     */
    private String goodsFlavor;

    /**
     * 数量
     */
    private Integer number;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 创建时间
     */
    private Date createTime;
}
