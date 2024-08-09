package com.gmgx.controller;

import com.gmgx.entity.Student;
import com.gmgx.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("student")
public class StudentController2 {

    @Autowired
    private IStudentService studentService;


    @RequestMapping("modifyStudentPhoto")
    public ModelAndView modifyStudentPhoto(Integer sno, MultipartFile photo, HttpServletRequest request){
        ModelAndView mv   = new ModelAndView();
         String oldName   =    photo.getOriginalFilename();
         String type  = oldName.substring(oldName.lastIndexOf("."));
         String newName   = UUID.randomUUID().toString().replaceAll("-","")+type;
         String photoPath  =  request.getServletContext().getRealPath("photo");
            File pathFile   =  new File(photoPath);
         if(!pathFile.exists()){
             pathFile.mkdirs();
         }

     // 拼接  要被转存到本地的文件名（全路径）
        File newFile   = new File(photoPath+"/"+newName);

        try {
            photo.transferTo(newFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



       boolean flag   =  studentService.modifyStudentPhoto(sno,"photo/"+newName);


        mv.setViewName("redirect:queryStudentBySno2?sno="+sno);
        return  mv;

    }



    @RequestMapping("modifyStudentResume")
    public ModelAndView modifyStudentResume(Integer sno, MultipartFile resume, HttpServletRequest request){
        ModelAndView mv   = new ModelAndView();
        String oldName   =    resume.getOriginalFilename();
        String type  = oldName.substring(oldName.lastIndexOf("."));
        String newName   = UUID.randomUUID().toString().replaceAll("-","")+type;
        String resumePath  =  request.getServletContext().getRealPath("resume");
        File pathFile   =  new File(resumePath);
        if(!pathFile.exists()){
            pathFile.mkdirs();
        }

        // 拼接  要被转存到本地的文件名（全路径）
        File newFile   = new File(resumePath+"/"+newName);

        try {
            resume.transferTo(newFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        boolean flag   =  studentService.modifyStudentResume(sno,"resume/"+newName);

        mv.setViewName("redirect:queryStudentBySno2?sno="+sno);

        return  mv;

    }


    @RequestMapping("queryStudentBySno2")
    public ModelAndView queryStudentBySno2(Integer  sno){

        ModelAndView mv   = new   ModelAndView();
        Student student   =  studentService.queryStudentBySno(sno);
        mv.addObject("student",student);
        // 修改成功 通过 视图解析器 之后的地址  一个绝对路径  工程名/student/success.jsp
        mv.setViewName("student/success");
        return mv;
    }




}
