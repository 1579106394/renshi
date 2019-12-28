package com.dmm.utils;

/**
 * @Author: 杨德石
 * @Date: 2019/12/22 19:23
 * @Version 1.0
 */
public class R {

    private Integer code;
    private String msg;
    private Object data;

    public R() {
    }

    public R(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
