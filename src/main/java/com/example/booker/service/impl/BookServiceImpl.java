package com.example.booker.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.booker.entity.Book;
import com.example.booker.mapper.BookMapper;
import com.example.booker.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author Scheelite
 * @date 2022/2/1
 * @email jwei.gan@qq.com
 * @description
 **/
@Slf4j
@Service("BookService")
public class BookServiceImpl extends ServiceImpl<BookMapper, Book>
        implements BookService {

    @Resource
    BookMapper bookMapper;

    @Override
    public IPage<Book> selectBookPage(Long categoryId, String order, Integer page, Integer rows){
        Page<Book> bookPage = new Page<Book>(page,rows);
        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
        if (Objects.nonNull(categoryId) && categoryId != -1) {
            queryWrapper.eq(Book::getCategoryId,categoryId);
        }
        if (Objects.nonNull(order)) {
            if(order.equals("quantity")){
                queryWrapper.orderByDesc(Book::getQuantity);
            }else if (order.equals("score")){
                queryWrapper.orderByDesc(Book::getScore);
            }
        }
        return bookMapper.selectPage(bookPage,queryWrapper);
    }

    @Override
    public Book getOne(Long id) {
        return bookMapper.selectById(id);
    }
}
