package com.gmself.bingobingo.module.subject.entity.resp;

import com.gmself.bingobingo.responseEntity.Resp_result;

public class RespPunch extends Resp_result{

    private int code;
    private String msg;

    public RespPunch(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
