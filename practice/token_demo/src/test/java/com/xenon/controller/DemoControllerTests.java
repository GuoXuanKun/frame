package com.xenon.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DemoControllerTests {
    @Autowired
    private DemoController demoController;

    @Test
    public void testLogin(){
        demoController.login();
    }
}
