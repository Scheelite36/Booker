package com.example.booker.exception;

import com.example.booker.consts.ResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Scheelite
 * @date 2022/3/17
 * @email jwei.gan@qq.com
 * @description
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BussinessException extends RuntimeException{
    private Integer code;
    private String msg;

    public BussinessException(ResponseEnum responseEnum){
        this(responseEnum.getCode(), responseEnum.getMsg());
    }
}
