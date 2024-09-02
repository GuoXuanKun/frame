package com.xenon.controller;

import com.xenon.common.Result;
import com.xenon.entity.Employee;
import com.xenon.service.EmployeeService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 员工信息 前端控制器
 * </p>
 *
 * @author wuyunbin
 * @since 2024-09-01
 */
@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;

    @PostMapping("login")
    public Result<String> login(@RequestBody Employee employee){
        log.info("employee:{}",employee);
       String token =  employeeService.login(employee);
       return Result.success(token);
    }

    @GetMapping("list")
    public Result<List<Employee>> list(){
        List<Employee> list = employeeService.list();
        return Result.success(list);
    }

}
