package com.springboot.demo1.entity;

import lombok.Data;

@Data
public class BaseException extends Exception {

    /**
     * 错误码
     */
    private int code;

    /**
     * 消息
     */
    private String message;

    public BaseException(String message,int code){
        super();
        this.code = code;
        this.message = message;
    }

    public BaseException(String message,int code,Throwable e){
        super(message,e);
        this.message = message;
        this.code = code;
    }

}
