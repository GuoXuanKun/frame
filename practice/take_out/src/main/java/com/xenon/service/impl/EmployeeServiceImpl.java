package com.xenon.service.impl;

import cn.hutool.crypto.digest.BCrypt;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xenon.entity.Employee;
import com.xenon.mapper.EmployeeMapper;
import com.xenon.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xenon.utils.JwtUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工信息 服务实现类
 * </p>
 *
 * @author wuyunbin
 * @since 2024-09-01
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    @Resource
    private JwtUtils jwtUtils;
    @Override
    public String login(Employee employee) {
        //2.构造条件
        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Employee::getUsername,employee.getUsername())
                .or()
                .eq(Employee::getPhone,employee.getPhone());
        //1. 根据用户名或者密码查询用户信息
        Employee employeeInDb = this.getOne(wrapper);

        //3.判断是否查询到用户
        if(employeeInDb == null){
            throw new RuntimeException("用户名错误");
        }

        //4.比较密码
        if(!BCrypt.checkpw(employee.getPassword(),employeeInDb.getPassword())){
            throw new RuntimeException("密码错误");
        }
        //5.签发token

        String token = jwtUtils.createJwt(
                employeeInDb.getId(),
                null,
                60*60*24*7L,
                "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890"
        );
        return token;
    }

}
