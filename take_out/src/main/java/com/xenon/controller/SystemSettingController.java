package com.xenon.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequestMapping("systemSetting")
@RestController
public class SystemSettingController {

    @RequestMapping("detail")
    public String detail() {

        return "{\n" +
                "  \"success\": true,\n" +
                "  \"errorCode\": 20000,\n" +
                "  \"message\": \"请求成功\",\n" +
                "  \"data\": {\n" +
                "    \"id\": \"1\",\n" +
                "    \"blogName\": \"sanmoo\",\n" +
                "    \"author\": \"wuyunbin\",\n" +
                "    \"introduction\": \"这个人很懒什么都没留下\",\n" +
                "    \"avatar\": \"http://sf1ulkj4a.hn-bkt.clouddn.com/2024/07/03/148bad6e0c3c4e7a8a459b4cb67e2150.png\",\n" +
                "    \"githubHome\": \"#\",\n" +
                "    \"csdnHome\": \"#\",\n" +
                "    \"giteeHome\": \"#\",\n" +
                "    \"zhihuHome\": \"#\"\n" +
                "  }\n" +
                "}";
    }
}
