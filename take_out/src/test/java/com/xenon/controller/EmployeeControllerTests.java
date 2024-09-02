package com.xenon.controller;


import com.xenon.common.Result;
import com.xenon.entity.Employee;
import com.xenon.exceptions.BusinessException;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/*
测试驱动开发
 */

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
        //1. 调用登录方法
        Result<String> login = employeeController.login(employee);

        log.info("{}",login);
    }

    @Test
    public void testLoginWithErrorPassword(){

        //2.断言
        BusinessException e = Assertions.assertThrows(BusinessException.class, () -> {
            Employee employee = new Employee();
            employee.setUsername("admin");
            employee.setPassword("1234567");
            //1. 调用登录方法
            Result<String> login = employeeController.login(employee);
        });

        log.info(e.getMessage());
        //3.断言提示信息是否正确
        Assertions.assertEquals("用户名或密码错误",e.getMessage());

    }

    @Test
    public void testLoginWithErrorUsername(){
        //2.断言
        BusinessException e = Assertions.assertThrows(BusinessException.class, () -> {
            Employee employee = new Employee();
            employee.setUsername("admin1");
            employee.setPassword("123456");
            //1. 调用登录方法
            Result<String> login = employeeController.login(employee);
        });
        //3.断言提示信息是否正确
        Assertions.assertEquals("用户名或密码错误",e.getMessage());
    }


}
