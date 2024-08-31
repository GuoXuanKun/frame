package com.xenon.mapper;

import com.xenon.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wuyunbin
 * @since 2024-08-31
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
