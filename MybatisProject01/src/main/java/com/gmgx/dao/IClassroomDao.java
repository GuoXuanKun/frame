package com.gmgx.dao;

import com.gmgx.dto.ClassroomDto;
import com.gmgx.entity.Classroom;

import java.util.List;

public interface IClassroomDao {

    public List<ClassroomDto> queryAllClassroomAndStudent();
    public List<Classroom> queryAllClassroomAndStudent2();

    public Classroom   queryClassroomByCno(Integer cno);


}
