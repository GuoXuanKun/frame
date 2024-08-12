package com.gmgx.controller;

import com.gmgx.entity.Student;
import com.gmgx.service.IStudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*@RestController
* 组合注解:包含很多注解
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Controller
@ResponseBody  注意这个
* */
@RestController
@RequestMapping("teacher2")

@Api(value = "teacher2",description = "教师的控制类2")
public class TeacherContoller2 {

    @Autowired
  private  IStudentService studentService;

 // restFul 风格  让地址栏更加简单点
/*    @RequestMapping(value = "queryAllStudent",method = RequestMethod.GET)*/
//    @GetMapping("queryAllStudent")
    @GetMapping
    @ApiOperation(value = "查询全部学生",httpMethod = "GET")
    public List<Student> queryAllStudent(){

      return    studentService.queryAllStudent();

    }


  @GetMapping("/{sno}")
  @ApiOperation(value = "通过学号查询学生",httpMethod = "GET")
  @ApiImplicitParams({
           @ApiImplicitParam(name = "sno", value = "学号", required = true, dataType ="int", paramType = "path"),
          })
  public Student queryStudentBySno(@PathVariable("sno") Integer sno){
    System.out.println("sno:"+sno);

    return    studentService.queryStudentBySno(sno);

  }







  @PostMapping
  @ApiOperation(value = "添加学生",httpMethod = "POST")
  @ApiImplicitParams({
         // @ApiImplicitParam(name = "sno", value = "学号", required = false, dataType ="int", paramType = "query"),
          @ApiImplicitParam(name = "sname", value = "姓名", required = true, dataType = "String", paramType = "query"),
          @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String", paramType = "query")
  })
  public boolean addStudent(Student student){

    return   studentService.addStudent(student);

  }



  @PostMapping("/{sname}/{password}")
  @ApiOperation(value = "添加学生2",httpMethod = "POST")
  @ApiImplicitParams({
          @ApiImplicitParam(name = "sname", value = "姓名", required = true, dataType = "String", paramType = "path"),
          @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String", paramType = "path")
  })
  public boolean addStudent2(@PathVariable("sname") String sname,@PathVariable("password") String password){
    System.out.println("添加学生2"+sname+","+password);
    return   studentService.addStudent(new Student(null,sname,password));

  }









  @DeleteMapping
  @ApiOperation(value = "删除学生",httpMethod = "DELETE")
  @ApiImplicitParams({
          @ApiImplicitParam(name = "sno", value = "学号",paramType = "query",dataType ="int"),
  })
  public boolean deleteStudentBySno( Integer sno){
    System.out.println(sno);
    return   studentService.deleteStudentBySno(sno);

  }


  @PutMapping
  @ApiOperation(value = "修改学生",httpMethod = "PUT")
  @ApiImplicitParams({
          @ApiImplicitParam(name = "sno", value = "学号", required = false, dataType ="int",paramType = "query",defaultValue = "1"),
          @ApiImplicitParam(name = "sname", value = "姓名", required = true, dataType = "String",paramType = "query"),
          @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String",paramType = "query")
  })
  public boolean modifyStudent(Student student){

    return   studentService.modifyStudent(student);

  }

}
