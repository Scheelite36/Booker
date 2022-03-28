package com.example.booker.consts;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Scheelite
 * @date 2022/3/15
 * @email jwei.gan@qq.com
 * @description
 **/
@Getter
@AllArgsConstructor
public enum ResponseEnum {

    SUCESS(200,"success"),
    DUPLICATE_NAME(1001,"用户名重复"),
    VERIFY_CODE_ERROR(1002,"验证码错误"),
    WRONG_PASSWORD(1003,"密码错误"),
    NOT_EXSIT(1004,"用户不存在"),
    BUSSINESS_ERROR(3000,"操作失败"),
    NEED_LOGIN(3001,"需要登陆"),
    UNKNOWN_ERROR(3003,"请联系管理员");
    private Integer code;
    private String msg;
}
