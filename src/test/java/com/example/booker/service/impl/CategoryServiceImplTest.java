package com.example.booker.service.impl;

import com.example.booker.entity.Category;
import com.example.booker.service.CategoryService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Scheelite
 * @date 2022/1/18
 * @email jwei.gan@qq.com
 * @description
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CategoryServiceImplTest extends TestCase {
    @Resource
    CategoryService categoryService;
    @Test
    public void getAllCategories(){
        List<Category> allCategories = categoryService.getAllCategories();
        for (Category c:
             allCategories) {
            System.out.println(c);
        }
    }
}