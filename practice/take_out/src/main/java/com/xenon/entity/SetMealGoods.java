package com.xenon.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 套餐商品关系
 * </p>
 *
 * @author wuyunbin
 * @since 2024-09-01
 */
@Getter
@Setter
@TableName("set_meal_goods")
public class SetMealGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 套餐id 
     */
    private String setMealId;

    /**
     * 商品id
     */
    private String goodsId;

    /**
     * 商品名称 （冗余字段）
     */
    private String name;

    /**
     * 商品原价（冗余字段）
     */
    private BigDecimal price;

    /**
     * 份数
     */
    private Integer copies;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 修改人
     */
    private String updateUser;

    /**
     * 是否删除
     */
    private Integer isDeleted;
}
