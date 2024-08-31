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
    public Object list(){
        return userService.list();
    }

    @GetMapping("findByName")
    public Object findByName(String name){
        // 2.
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        //3.
        wrapper.eq(User::getName,name);
        // 1.
        List<User> list = userService.list(wrapper);
        return list;
    }

    @GetMapping("findByEmail")
    public Object findByEmail(String email){
        // 2.
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        // 3.
        wrapper.eq(User::getEmail,email);
        // 1.
        User user = userService.getOne(wrapper);
        // 4.
        return user;
    }

    @PostMapping("save")
    public Object save(@RequestBody User user){
        return userService.save(user);
    }

    @PutMapping("update")
    public Object update(@RequestBody User user){
        return userService.updateById(user);
    }

    @GetMapping("getPage")
    public Object getPage(int current,int size){
        /*
        2. 页面规格
        current-当前页码
        size-每页显示条数
         */
        /*
        3. 查询条件
         */
        IPage<User> pageInfo = new Page<>(current, size);
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.gt(User::getAge,18);
        //1.
        IPage<User> page = userService.page(pageInfo, wrapper);
        return page;
    }


}
