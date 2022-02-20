package com.example.booker.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.booker.entity.Book;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author Scheelite
 * @date 2022/2/1
 * @email jwei.gan@qq.com
 * @description
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class BookServiceTest extends TestCase {

    @Resource
    BookService bookService;

    @Test
    public void testSelectBookPage() {
        IPage<Book> bookIPage = bookService.selectBookPage(2L,"score",1, 4);
        bookIPage.getRecords().stream().map(Book::getBookName).forEach(System.out::println);
        System.out.println(bookIPage.getPages());
        System.out.println(bookIPage.getTotal());
    }
}