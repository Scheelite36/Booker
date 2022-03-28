package com.example.booker.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.booker.consts.Consts;
import com.example.booker.entity.Book;
import com.example.booker.entity.Evaluation;
import com.example.booker.entity.Member;
import com.example.booker.entity.MemberReadState;
import com.example.booker.service.BookService;
import com.example.booker.service.EvaluationService;
import com.example.booker.service.MemberReadStateService;
import com.example.booker.service.MemberService;
import com.example.booker.utils.ResponseUtils;
import com.example.booker.utils.UserUtils;
import jdk.nashorn.internal.ir.CallNode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

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

    @Resource
    MemberReadStateService readStateService;

    // 获取图书列表
    @GetMapping("/books")
    @ResponseBody
    public IPage<Book> getBooks(Long categoryId, String order, Integer page, Integer size) {
        return bookService.selectBookPage(categoryId, order, page, size);
    }

    // 获取图书详情
    @GetMapping("/book/{id}")
    public ModelAndView getOne(@PathVariable("id") Long id, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("/detail");
        Book book = bookService.getOne(id);
        List<Evaluation> evaluationList = evaluationService.getEvaluation(id);
        // 该页面不被登陆过滤器拦截 所以只能直接从session中获取 而其他加入过滤器的则直接从userutils中获取
        Member loginMember = (Member) request.getSession().getAttribute(Consts.BOOKER_MEMBER);
        // 获取当前用户 当前阅读状态
        if (!Objects.isNull(loginMember)) {
            System.out.println(loginMember.getNickname());
            MemberReadState state = readStateService.getState(id, loginMember.getMemberId());
            Evaluation evaluation = evaluationService.getOneBySelect(loginMember.getMemberId(), id);
            mv.addObject("loginMember",loginMember);
            if (!Objects.isNull(state)) {
                mv.addObject("state", state);
            }
            if (!Objects.isNull(evaluation)) {
                mv.addObject("evaluation",evaluation);
            }
        }
        mv.addObject("book", book);
        mv.addObject("evaluationList", evaluationList);
        return mv;
    }

    // 更新阅读状态
    @PostMapping("/updateReadState")
    @ResponseBody
    public ResponseUtils updateReadState(Long bookId,Integer readState){
        readStateService.updateReadState(bookId,readState);
        return ResponseUtils.success();
    }

    // 提交评价
    @PostMapping("/evaluate")
    @ResponseBody
    public ResponseUtils evaluate(Long bookId, Integer score, String content){
        evaluationService.evaluate(bookId,score,content);
        return ResponseUtils.success();
    }

    // enjoy button
    @PostMapping("/enjoy")
    @ResponseBody
    public ResponseUtils enjoy(Long evaluationId){
        return ResponseUtils.success(evaluationService.enjoy(evaluationId));
    }
}
