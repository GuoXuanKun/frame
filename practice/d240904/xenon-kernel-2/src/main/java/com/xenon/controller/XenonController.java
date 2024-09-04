package com.xenon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("xenon")
public class XenonController {

    @GetMapping("kernel")
    public String kernel(){
        return "xenon-kernel";
    }
}
