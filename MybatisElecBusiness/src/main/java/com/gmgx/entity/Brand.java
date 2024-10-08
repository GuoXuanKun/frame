package com.gmgx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Brand {
    private int id;
    private String brandName;
    private String companyName;
    private int ordered;
    private String description;
    private String status;

    public Brand(String brandName, String companyName, int ordered, String description, String status) {
        this.brandName = brandName;
        this.companyName = companyName;
        this.ordered = ordered;
        this.description = description;
        this.status = status;
    }
}
