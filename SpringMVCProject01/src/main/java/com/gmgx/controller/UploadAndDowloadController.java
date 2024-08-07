package com.gmgx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("uploadAndDownload")

public class UploadAndDowloadController {


    @RequestMapping("upload")
    public ModelAndView upload(String sname, MultipartFile photo, HttpServletRequest request){
        ModelAndView mv   = new ModelAndView();

        System.out.println(sname);
        System.out.println(photo);
        System.out.println(photo.getName());
        // 得到 原始的文件名（上传文件的 原名）
        System.out.println(photo.getOriginalFilename());


       String  oldFilename  =   photo.getOriginalFilename();
       // 获得它的后缀
       int  index  = oldFilename.lastIndexOf(".");
       String type   =   oldFilename.substring(index);

       // UUID.randomUUID().toString().replaceAll("-","")
        // 获得一个 32位随机数   去掉它的间隔 -
        String newFilename =    UUID.randomUUID().toString().replaceAll("-","")+type;
        // 生成一个新名字
        System.out.println(newFilename);


        // 1 如果 将  上传文件锁定 在 某个固定位置，比如 当前电脑的D盘 upload文件夹
        // File pathFile   = new File("D://upload"); 直接写死了
        // 2 当前工程的所在位置的某个指定位置
      String path   =   request.getServletContext().getRealPath("/upload");
        File pathFile  = new File(path);
        // 判断 路径是否存在，不存在 就新建
        if(!pathFile.exists()){
            pathFile.mkdirs();
        }
        //   拼接好 全路径（路径+文件名）
        String newPath   = path+"/"+newFilename;


        try {
             // 提供了 转移 方法  将当前上传的文件（在内存中） 转移到 指定位置（硬盘中）
            photo.transferTo(new File(newPath));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return  mv;
    }



    @RequestMapping("upload2")
    public ModelAndView upload2(String sname, MultipartFile photo,MultipartFile resume,  HttpServletRequest request){
        ModelAndView mv   = new ModelAndView();

        System.out.println(sname);

        String path   =   request.getServletContext().getRealPath("/upload");
        File pathFile  = new File(path);
        // 判断 路径是否存在，不存在 就新建
        if(!pathFile.exists()){
            pathFile.mkdirs();
        }

        System.out.println(uploadUtil(photo, path));

        System.out.println(uploadUtil(resume, path));


        return  mv;
    }




    public String uploadUtil( MultipartFile  multipartFile ,String path){

        // 得到 原始的文件名（上传文件的 原名）
        String  oldFilename  =   multipartFile.getOriginalFilename();
        // 获得它的后缀
        int  index  = oldFilename.lastIndexOf(".");
        String type   =   oldFilename.substring(index);


        String newFilename =    UUID.randomUUID().toString().replaceAll("-","")+type;
        System.out.println(newFilename);



        //   拼接好 全路径（路径+文件名）
        String newPath   = path+"/"+newFilename;

        try {
            // 提供了 转移 方法  将当前上传的文件（在内存中） 转移到 指定位置（硬盘中）
            multipartFile.transferTo(new File(newPath));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return  newFilename;
    }






}
