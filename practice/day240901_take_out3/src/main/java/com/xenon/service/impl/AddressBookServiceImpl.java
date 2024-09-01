package com.xenon.service.impl;

import com.xenon.entity.AddressBook;
import com.xenon.mapper.AddressBookMapper;
import com.xenon.service.AddressBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 地址管理 服务实现类
 * </p>
 *
 * @author wuyunbin
 * @since 2024-09-01
 */
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {

}
