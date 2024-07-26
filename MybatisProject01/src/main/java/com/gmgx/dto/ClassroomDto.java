package com.gmgx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClassroomDto {

    private Integer cno;
    private String cname;
    private String addr;

    private Integer sno;
    private String sname;
    private String password;
    private String sex;
    private Integer age;
    private Date birthday;

}
