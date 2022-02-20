package com.example.booker.controller;

import com.example.booker.entity.Category;
import com.example.booker.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Scheelite
 * @date 2022/1/18
 * @email jwei.gan@qq.com
 * @description
 **/
@Controller
@RequestMapping
public class CategoryController {

    @Resource
    CategoryService categoryService;

    @GetMapping
    public ModelAndView showCategories(){
        // 绑定视图文件的名字
        ModelAndView mv = new ModelAndView("index");
        List<Category> allCategories = categoryService.getAllCategories();
        // 添加属性名
        mv.addObject("categories",allCategories);
        return mv;
    }
}
