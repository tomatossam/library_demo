package com.springboot.demo1.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Response implements Serializable {

    /**
     * 返回信息
     */
    private String msg = "";

    /**
     * 传输的数据
     */
    private Object data;

    /**
     *  返回值，成功时返回“100”，其他码均为失败
     */
    private String result = "100";

    public Response(){}

    public Response(String msg) {
        this.msg = msg;
    }

    public Response(String msg, Object data) {
        this.msg = msg;
        this.data = data;
    }

    /**
     * 正常响应 处理成功
     * @return
     */
    public Response normalResponse() {
        return new Response("调用成功");
    }

    public Response normalResponse(Object data) {
        return new Response("调用成功", data);
    }

}
