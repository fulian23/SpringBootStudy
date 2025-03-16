package com.example.demo.entity;


import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseVO<T> {
    Integer code;
    String msg;
    boolean success;
    T data;

    public ResponseVO(T data){
        this.code = 200;
        this.msg = "OK";
        this.data = data;
        this.success = true;

    }

    public ResponseVO(Integer code, String msg){
        this.code = code;
        this.msg = msg;
        this.success = false;
    }

    public ResponseVO(int code, String msg, boolean success, T data){
        this.code = code;
        this.msg = msg;
        this.success = success;
        this.data = data;
    }

    public static <T> ResponseVO<T> SUCCESS(T data){
        return new ResponseVO<>(data);
    }

    public static <T> ResponseVO<T> SUCCESS(){
        return new ResponseVO<>(null);
    }
    public static <T> ResponseVO<T> FAIL(){
        return new ResponseVO<>(500,"系统错误");
    }
    public static <T> ResponseVO<T> FAIL(Integer code, String msg){
        return new ResponseVO<>(code,msg);
    }

}
