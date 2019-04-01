package com.gmself.bingobingo.responseEntity;

import com.alibaba.fastjson.annotation.JSONField;

public class Resp_status {

    /** 请求结果代码（Y/N） */
    private String RR;

    /** 请求结果错误代码 */
    private String RW;

    @JSONField(name="RR")
    public String getRR() {
        return RR;
    }

    @JSONField(name="RR")
    public void setRR(String RR) {
        this.RR = RR;
    }

    @JSONField(name="RW")
    public String getRW() {
        return RW;
    }

    @JSONField(name="RW")
    public void setRW(String RW) {
        this.RW = RW;
    }
}
