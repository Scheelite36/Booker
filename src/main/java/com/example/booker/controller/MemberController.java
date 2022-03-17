package com.example.booker.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.booker.entity.Member;
import com.example.booker.service.MemberService;
import com.example.booker.utils.ResponseUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Scheelite
 * @date 2022/2/28
 * @email jwei.gan@qq.com
 * @description 用户界面接口
 **/
@Controller
public class MemberController {

    @Resource
    MemberService memberService;

    @GetMapping("/register.html")
    public ModelAndView showRegister() {
        return new ModelAndView("register");
    }

    @PostMapping("/registerr")
    @ResponseBody
    public ResponseUtils register(String username, String password, String nickname, String vc, HttpServletRequest request) throws NoSuchAlgorithmException {
        memberService.register(username,password,nickname,vc,request);
        return ResponseUtils.success();
    }
}
