package com.example.booker.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.booker.entity.Book;

/**
 * @author Scheelite
 * @date 2022/2/1
 * @email jwei.gan@qq.com
 * @description
 **/
public interface BookService extends IService<Book> {

    /**
     * 返回指定页图书
     * @param categoryId
     * @param order
     * @param page
     * @param rows
     * @return
     */
    IPage<Book> selectBookPage(Long categoryId, String order, Integer page, Integer rows);

    /**
     * 获取图书信息
     * @param id
     * @return
     */
    Book getOne(Long id);
}
