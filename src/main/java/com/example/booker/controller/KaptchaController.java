package com.example.booker.controller;

import com.google.code.kaptcha.Producer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Scheelite
 * @date 2022/2/27
 * @email jwei.gan@qq.com
 * @description 加载验证码的接口
 **/
@Controller
public class KaptchaController {

    @Resource
    private Producer kaptchaProducer;

    @GetMapping("/verifyCode")
    public void createVerifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 响应立即过期
        response.setDateHeader("Expires",0);
        // 不缓存任何数据
        response.setHeader("Cache-Control","no-store,no-cache,must-revalidate");
        response.setHeader("Cache-Control","post-check=0,pre-check=0");
        response.setHeader("Pragma","no-cache");
        // 生成验证码字符文本
        String text = kaptchaProducer.createText();
        request.getSession().setAttribute("kaptchaVerifyCode",text);
        BufferedImage image = kaptchaProducer.createImage(text);
        // 响应中加入图片字节流
        ServletOutputStream outputStream = response.getOutputStream();
        // 输出图片流
        ImageIO.write(image,"png",outputStream);
        outputStream.flush();
        outputStream.close();
    }
}
