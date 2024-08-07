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




}
