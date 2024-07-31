package com.gmgx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Commodity {
    private int commodityId;
    private String commodityName;
    private int repertory;
    private int volume;
    private String manager;
}
