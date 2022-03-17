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
    BUSSINESS_ERROR(3000,"操作失败");
    private Integer code;
    private String msg;
}
