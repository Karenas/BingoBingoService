package com.gmself.bingobingo.module.subject.entity.resp;

import com.gmself.bingobingo.function.weather.entity.HfWeatherNow;
import com.gmself.bingobingo.responseEntity.Resp_result;

public class RespGetWeatherNow extends Resp_result{

    private int code;
    private String msg;

    private HfWeatherNow weatherNow;

    public RespGetWeatherNow(int code, String msg) {
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

    public HfWeatherNow getWeatherNow() {
        return weatherNow;
    }

    public void setWeatherNow(HfWeatherNow weatherNow) {
        this.weatherNow = weatherNow;
    }
}
