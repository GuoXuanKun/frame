package com.xenon.controller;


import com.xenon.entity.Employee;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class EmployeeControllerTests {
    @Resource
    private EmployeeController employeeController;

    @Test
    public void testLoginSuccess(){
        Employee employee=new Employee();
        employee.setUsername("admin");
        employee.setPassword("123456");
        String login = employeeController.login(employee);
        log.info(login);
    }

    @Test
    public void testLoginWithErrorPassword(){

        // 2. 断言
        Assertions.assertThrows(RuntimeException.class,()->{
            Employee employee = new Employee();
            employee.setUsername("admin");
            employee.setPassword("1234567");
            // 1. 调用登录方法
            String login = employeeController.login(employee);
        });

    }
}
