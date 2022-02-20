package com.example.booker.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.booker.entity.Book;
import com.example.booker.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Scheelite
 * @date 2021/12/6
 * @email jwei.gan@qq.com
 * @description
 **/
@RestController
public class TestController {
    @Resource
    BookService bookService;

    @GetMapping("/test1")
    public ModelAndView test1(){
        return new ModelAndView("/test");
    }

    @GetMapping("/test2")
    public Map test2(){
        Map m = new HashMap<String,String>();
        m.put("name","giao");
        return m;
    }

    @GetMapping("/test3")
    public void test3(){
        IPage<Book> bookIPage = bookService.selectBookPage(2L,"quantity" ,1, 4);
        System.out.println(bookIPage.getTotal());
        System.out.println(bookIPage.getCurrent());
        bookIPage.getRecords().stream().map(Book::getBookName).forEach(System.out::println);
    }
}
