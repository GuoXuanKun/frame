package com.gmgx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Teacher {

    private Integer tno;
    private String tname;
    private String sex;

    private List<Student> myStuList;

    private Classroom myClassroom;

    public Teacher(Integer tno, String tname, String sex) {
        this.tno = tno;
        this.tname = tname;
        this.sex = sex;
    }

}
