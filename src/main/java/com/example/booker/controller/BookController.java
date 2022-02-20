package com.example.booker.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.booker.entity.Book;
import com.example.booker.entity.Evaluation;
import com.example.booker.service.BookService;
import com.example.booker.service.EvaluationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Scheelite
 * @date 2022/2/15
 * @email jwei.gan@qq.com
 * @description
 **/

@Controller
public class BookController {

    @Resource
    BookService bookService;

    @Resource
    EvaluationService evaluationService;

    @GetMapping("/books")
    @ResponseBody
    public IPage<Book> getBooks(Long categoryId, String order, Integer page, Integer size) {
        return bookService.selectBookPage(categoryId, order, page, size);
    }

    @GetMapping("/book/{id}")
    public ModelAndView getOne(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("/detail");
        Book book = bookService.getOne(id);
        List<Evaluation> evaluationList = evaluationService.getEvaluation(id);
        mv.addObject("book", book);
        mv.addObject("evaluationList", evaluationList);
        return mv;
    }
}
