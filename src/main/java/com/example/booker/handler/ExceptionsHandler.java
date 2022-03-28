package com.example.booker.handler;

import com.example.booker.consts.ResponseEnum;
import com.example.booker.exception.BussinessException;
import com.example.booker.utils.ResponseUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Scheelite
 * @date 2022/3/17
 * @email jwei.gan@qq.com
 * @description
 **/
@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(Exception.class)
    public ResponseUtils exceptions(Exception e){
        return ResponseUtils.error(ResponseEnum.UNKNOWN_ERROR.getCode(), ResponseEnum.UNKNOWN_ERROR.getMsg());
    }

    @ExceptionHandler(BussinessException.class)
    public ResponseUtils bussinessExceptionHandler(BussinessException bussinessException){
        return ResponseUtils.error(bussinessException.getCode(), bussinessException.getMsg());
    }
}
