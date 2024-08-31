package com.xenon.service.impl;

import com.xenon.entity.User;
import com.xenon.mapper.UserMapper;
import com.xenon.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wuyunbin
 * @since 2024-08-31
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
