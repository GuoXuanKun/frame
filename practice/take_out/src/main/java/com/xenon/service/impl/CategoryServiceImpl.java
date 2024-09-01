package com.xenon.service.impl;

import com.xenon.entity.Category;
import com.xenon.mapper.CategoryMapper;
import com.xenon.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品及套餐分类 服务实现类
 * </p>
 *
 * @author wuyunbin
 * @since 2024-09-01
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
