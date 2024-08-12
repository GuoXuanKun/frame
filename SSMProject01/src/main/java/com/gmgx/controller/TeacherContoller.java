package com.gmgx.controller;

import com.gmgx.entity.Student;
import com.gmgx.service.IStudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("teacher")
/* 配 在类 上面，控制层类的说明 */
//@Api(tags = "教师的控制类")
/*   */
@Api(value = "teacher",description = "教师的控制类")
public class TeacherContoller {

  @Autowired
  private  IStudentService studentService;

  // 如果实现了前后端分离，后台（SSM工程）返回不再是jsp页面，而是 json数据
  // restFul 风格 设置  约定 GET查询  POST 添加  PUT 更新 DELETE  删除

  @ResponseBody
  @RequestMapping(value = "queryAllStudent",method = RequestMethod.GET)
  @ApiOperation(value = "查询全部学生",httpMethod = "GET")
  public List<Student> queryAllStudent(){

    return    studentService.queryAllStudent();

  }
/*
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType ="", paramType = "form"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "age", value = "年龄", required = false, dataType = "int", paramType = "form"),
    })*/


  @ResponseBody
  @RequestMapping(value = "addStudent",method = RequestMethod.POST)
  @ApiOperation(value = "添加学生",httpMethod = "POST")
  @ApiImplicitParams({
          @ApiImplicitParam(name = "sno", value = "学号", required = false, dataType ="int", paramType = "query"),
          @ApiImplicitParam(name = "sname", value = "姓名", required = true, dataType = "String", paramType = "query"),
          @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String", paramType = "query")
  })
  public boolean addStudent(Student student){

    return   studentService.addStudent(student);

  }



  @ResponseBody
  @RequestMapping(value = "deleteStudentBySno",method = RequestMethod.DELETE)
  @ApiOperation(value = "删除学生",httpMethod = "DELETE")
  @ApiImplicitParams({
          @ApiImplicitParam(name = "sno", value = "学号",paramType = "query",dataType ="int"),
  })
  public boolean deleteStudentBySno( Integer sno){
    System.out.println(sno);
    return   studentService.deleteStudentBySno(sno);

  }

  @ResponseBody
  @RequestMapping(value = "modifyStudent",method = RequestMethod.PUT)
  @ApiOperation(value = "修改学生",httpMethod = "PUT")
  @ApiImplicitParams({
          @ApiImplicitParam(name = "sno", value = "学号", required = false, dataType ="int",paramType = "query"),
          @ApiImplicitParam(name = "sname", value = "姓名", required = true, dataType = "String",paramType = "query"),
          @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String",paramType = "query")
  })
  public boolean modifyStudent(Student student){

    return   studentService.modifyStudent(student);

  }


}
