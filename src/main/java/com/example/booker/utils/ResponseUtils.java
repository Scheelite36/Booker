package com.example.booker.utils;

import com.example.booker.consts.ResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Scheelite
 * @date 2022/3/15
 * @email jwei.gan@qq.com
 * @description
 **/
@Getter
@Setter
@AllArgsConstructor
public class ResponseUtils<T> {
    private Integer code;
    private String msg;
    private T data;

    public static ResponseUtils success(){
        return new ResponseUtils(ResponseEnum.SUCESS.getCode(), ResponseEnum.SUCESS.getMsg(), null);
    }

    public static ResponseUtils success(Object data){
        return new ResponseUtils(ResponseEnum.SUCESS.getCode(), ResponseEnum.SUCESS.getMsg(), data);
    }

    public static ResponseUtils error(Integer code, String msg){
        return new ResponseUtils(code,msg,null);
    }
}
