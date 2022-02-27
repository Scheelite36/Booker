package com.example.booker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping("/register.html")
    public ModelAndView showRegister() {
        return new ModelAndView("register");
    }

    @PostMapping("/registerr")
    @ResponseBody
    public Map register(String username, String password, String vc, HttpServletRequest request){
        String kaptchaVerifyCode = (String) request.getSession().getAttribute("kaptchaVerifyCode");
        HashMap map = new HashMap();
        if (Objects.isNull(vc) || Objects.isNull(kaptchaVerifyCode) || !vc.equalsIgnoreCase(kaptchaVerifyCode)) {
            map.put("code","3000");
            map.put("msg","验证码错误");
        }else{
            map.put("code","0");
            map.put("msg","success");
        }
        return map;
    }
}
