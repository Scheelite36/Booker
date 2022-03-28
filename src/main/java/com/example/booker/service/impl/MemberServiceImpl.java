package com.example.booker.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.booker.consts.ResponseEnum;
import com.example.booker.entity.Member;
import com.example.booker.exception.BussinessException;
import com.example.booker.mapper.MemberMapper;
import com.example.booker.service.MemberService;
import com.example.booker.utils.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

/**
 * @author Scheelite
 * @date 2022/2/20
 * @email jwei.gan@qq.com
 * @description
 **/
@Slf4j
@Service("MemberService")
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

    @Override
    public void register(String username, String password, String nickname, String vc, HttpServletRequest request) {
        // 校验验证码
        checkVerifyCode(vc,request);
        // 是否用户名重复
        LambdaQueryWrapper<Member> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Member::getUsername,username);
        if (this.count(queryWrapper)!=0) {
            throw new BussinessException(ResponseEnum.DUPLICATE_NAME.getCode(),ResponseEnum.DUPLICATE_NAME.getMsg());
        }
        // 保存 注册
        int salt = (int) (Math.random() * 1000);
        String encodePass = MD5Utils.getMD5String(password+salt);
        Member build = Member.builder().username(username).password(encodePass)
                .nickname(nickname).salt(salt).createTime(LocalDateTime.now()).build();
        this.save(build);
    }

    @Override
    public Member login(String username, String password, String vc, HttpServletRequest request) {
        checkVerifyCode(vc,request);
        // 查找用户
        LambdaQueryWrapper<Member> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Member::getUsername,username);
        Member one = this.getOne(queryWrapper);
        if (Objects.isNull(one)) {
            throw new BussinessException(ResponseEnum.NOT_EXSIT.getCode(), ResponseEnum.NOT_EXSIT.getMsg());
        }
        if (!MD5Utils.getMD5String(password + one.getSalt()).equals(one.getPassword())) {
            throw new BussinessException(ResponseEnum.WRONG_PASSWORD.getCode(), ResponseEnum.WRONG_PASSWORD.getMsg());
        }
        return one;
    }

    private void checkVerifyCode(String vc, HttpServletRequest request){
        // 校验验证码
        String kaptchaVerifyCode = (String) request.getSession().getAttribute("kaptchaVerifyCode");
        if (Objects.isNull(vc) || Objects.isNull(kaptchaVerifyCode) || !vc.equalsIgnoreCase(kaptchaVerifyCode)) {
            throw new BussinessException(ResponseEnum.VERIFY_CODE_ERROR.getCode(), ResponseEnum.VERIFY_CODE_ERROR.getMsg());
        }
    }
}
