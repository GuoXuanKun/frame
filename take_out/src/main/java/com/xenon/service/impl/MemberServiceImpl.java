package com.xenon.service.impl;

import com.xenon.entity.Member;
import com.xenon.mapper.MemberMapper;
import com.xenon.service.MemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author wuyunbin
 * @since 2024-09-01
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

}
