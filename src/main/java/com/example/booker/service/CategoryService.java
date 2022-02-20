package com.example.booker.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.booker.entity.Category;

import java.util.List;

/**
 * @author Scheelite
 * @date 2022/1/18
 * @email jwei.gan@qq.com
 * @description
 **/
public interface CategoryService extends IService<Category> {
    /**
     * 获取所有类别
     * @return
     */
    List<Category> getAllCategories();
}
