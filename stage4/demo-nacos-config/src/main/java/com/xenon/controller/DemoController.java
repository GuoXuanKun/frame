package com.xenon.controller;


import com.xenon.config.JwtConfig;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoController {
    //读取配置文件内容
    @Resource
    private JwtConfig jwtConfig;
    @GetMapping("index")
    public Long index(){
        return jwtConfig.getTtl();
    }
}
