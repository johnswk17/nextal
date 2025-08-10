package com.blanink.nextal.entity;

import lombok.Data;

/**
 * @Author:JohnShepherd
 * @Date: 2021/12/29 9:51
 * @Version 1.0
 */
@Data
public class ResultView<T> {
    //错误码
    private Integer code;
    //提示信息
    private String msg;

    private T data;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
