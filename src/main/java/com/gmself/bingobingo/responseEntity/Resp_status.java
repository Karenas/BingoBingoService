package com.gmself.bingobingo.responseEntity;

public class Resp_status {

    /** 请求结果代码（Y/N） */
    private String RR;

    /** 请求结果错误代码 */
    private String RW;

    public String getRR() {
        return RR;
    }

    public void setRR(String RR) {
        this.RR = RR;
    }

    public String getRW() {
        return RW;
    }

    public void setRW(String RW) {
        this.RW = RW;
    }
}
