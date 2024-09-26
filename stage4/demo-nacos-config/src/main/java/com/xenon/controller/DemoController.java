package com.xenon.controller;


import com.xenon.config.DiscoveryConfig;
import com.xenon.config.JwtConfig;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoController {
    //读取配置文件内容
    @Resource
    private JwtConfig jwtConfig;

    @Resource
    private DiscoveryConfig discoveryConfig;

    @Value("${server.port}")
    private String port;

    @GetMapping("index")
    public Long index(){

        System.out.println(discoveryConfig.getUsername());
        System.out.println(discoveryConfig.getPassword());
        System.out.println(discoveryConfig.getServerAddr());
        System.out.println(port);
        return jwtConfig.getTtl();
    }
}
