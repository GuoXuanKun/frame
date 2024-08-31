package com.xenon.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xenon.entity.User;
import com.xenon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wuyunbin
 * @since 2024-08-31
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public Object list() {
        return userService.list();
    }

    @GetMapping("findByName")
    public Object findByName(String name) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getName, name);
        List<User> list = userService.list(wrapper);
        return list;
    }

    @GetMapping("findByEmail")
    public Object findByEmail(String email) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getEmail, email);
        User user = userService.getOne(wrapper);
        return user;
    }

    @PostMapping
    public Object save(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping
    public Object update(@RequestBody User user) {
        boolean update = userService.updateById(user);
        return update;
    }

    @GetMapping("page")
    public Object getPage(int current, int size) {
        /*
        2. 页面规格
        current 当前页码
        size 每页显示条数
         */
        IPage<User> pageInfo = new Page<>(current, size);
        /*
        查询条件
         */
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.gt(User::getAge, 18);
        // 1.
        IPage<User> page = userService.page(pageInfo, wrapper);
        return page;
    }

}