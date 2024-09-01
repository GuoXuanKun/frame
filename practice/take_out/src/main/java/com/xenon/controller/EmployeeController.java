package com.xenon.controller;

import com.xenon.entity.Employee;
import com.xenon.service.EmployeeService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 员工信息 前端控制器
 * </p>
 *
 * @author wuyunbin
 * @since 2024-09-01
 */
@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    public String login(@RequestBody Employee employee){
        log.info("employee:{}",employee);
        String token=  employeeService.login(employee);
        return token;
    }

}
