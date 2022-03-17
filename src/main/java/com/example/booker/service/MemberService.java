package com.example.booker.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.booker.entity.Member;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Scheelite
 * @date 2022/2/20
 * @email jwei.gan@qq.com
 * @description
 **/
public interface MemberService extends IService<Member> {
    /**
     * 用户注册
     * @param username
     * @param password
     * @param nickname
     * @param vc
     * @param request
     * @throws NoSuchAlgorithmException
     */
    void register(String username, String password, String nickname, String vc, HttpServletRequest request) throws NoSuchAlgorithmException;
}
