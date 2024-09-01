package com.xenon.service;

import com.xenon.entity.Employee;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 员工信息 服务类
 * </p>
 *
 * @author wuyunbin
 * @since 2024-09-01
 */
public interface EmployeeService extends IService<Employee> {
    String login(Employee employee);

}
