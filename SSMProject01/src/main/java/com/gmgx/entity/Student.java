package com.gmgx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.ibatis.annotations.Delete;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

    private Integer sno;
    private String sname;
    private String password;
}
