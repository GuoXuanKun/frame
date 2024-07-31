package com.gmgx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ShoppingCart {
    private int cartId;
    private int userId;
    private int commodityId;
    private int univalence;
    private int num;
    private int total;

}
