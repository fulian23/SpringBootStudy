package com.example.demo.handler;



import com.example.demo.entity.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.connection.DefaultMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.validation.BindException;

import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
@Order(value = 1)
public class ControllerGlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseVO<?> handle(Exception e){
        log.error("<<<ExceptionHandle>>>:"+e.getMessage());
        return ResponseVO.FAIL(500,e.getMessage());
    }
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public ResponseVO<?> bindhandle(BindException e){
        String message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::
                getDefaultMessage).collect(Collectors.joining());
        log.debug(message);
        return ResponseVO.FAIL(500,message);
    }
    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public ResponseVO<?> runtimeExptionHandle(RuntimeException e){
        log.error("<<<ExceptionHandle>>>:"+e.getMessage());
        return ResponseVO.FAIL(500,e.getMessage());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseVO<?> methodArgumentNotValidExcptionHandle(MethodArgumentNotValidException e){
        String message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::
                getDefaultMessage).collect(Collectors.joining());
        log.debug("<<<methodArgumentNotValidExcptionHandle>>>:"+message);
        return ResponseVO.FAIL(500,message);
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResponseVO<?> httpMessageNotReadableExceptionHandle(){
        return ResponseVO.FAIL(500,"body请求为空");
    }
}
