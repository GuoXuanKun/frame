package com.gmgx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

public class Teacher {

    private Integer tno;
    private  String tname;
    private Classroom classroom;

    public Teacher() {

        System.out.println("无参构造，创建的节点");
    }

}
