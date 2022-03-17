package com.example.booker.handler;

import com.example.booker.exception.BussinessException;
import com.example.booker.utils.ResponseUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Scheelite
 * @date 2022/3/17
 * @email jwei.gan@qq.com
 * @description
 **/
@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(BussinessException.class)
    public ResponseUtils bussinessExceptionHandler(Integer code,String msg){
        return ResponseUtils.error(code,msg);
    }
}
