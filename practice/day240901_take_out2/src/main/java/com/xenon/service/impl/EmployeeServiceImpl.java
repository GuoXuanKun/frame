package com.xenon.service.impl;

import cn.hutool.crypto.digest.BCrypt;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xenon.entity.Employee;
import com.xenon.exceptions.BusinessException;
import com.xenon.exceptions.enumeration.ResponseEnum;
import com.xenon.mapper.EmployeeMapper;
import com.xenon.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xenon.utils.JwtUtils;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工信息 服务实现类
 * </p>
 *
 * @author wuyunbin
 * @since 2024-09-01
 */
@Slf4j
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    @Resource
    private JwtUtils jwtUtils;

    @Override
    public String login(Employee employee) {

        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Employee::getUsername,employee.getUsername())
                .or()
                .eq(Employee::getPhone,employee.getPhone());

        Employee employeeInDb = this.getOne(wrapper);

        if (employeeInDb==null){
            log.info("用户名:{}不存在",employee.getUsername());
            throw new BusinessException(ResponseEnum.INVALID_ACCOUNT);
        }

        if (!BCrypt.checkpw(employee.getPassword(),employeeInDb.getPassword())){
            log.info("用户名:{},密码:{}错误",employee.getUsername(),employee.getPassword());
            throw new BusinessException(ResponseEnum.INVALID_ACCOUNT);
        }

        String token = jwtUtils.createJwt(
                employeeInDb.getId(),
                null,
                60 * 60 * 24 * 7L,
                "012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789"
        );
        return token;
    }
}
