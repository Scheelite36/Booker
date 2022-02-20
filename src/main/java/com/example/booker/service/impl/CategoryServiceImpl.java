package com.example.booker.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.booker.entity.Category;
import com.example.booker.mapper.CategoryMapper;
import com.example.booker.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Scheelite
 * @date 2022/1/18
 * @email jwei.gan@qq.com
 * @description
 **/
@Service("CategoryService")
@Slf4j
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper,Category> implements CategoryService {

    @Override
    public List<Category> getAllCategories(){
        return this.list();
    }
}
