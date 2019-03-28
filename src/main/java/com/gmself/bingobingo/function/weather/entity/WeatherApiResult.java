package com.gmself.bingobingo.function.weather.entity;

import java.util.List;

public class WeatherApiResult {

    private int code;
    private WeatherData data;
    private String msg;
    private Rc rc;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public WeatherData getData() {
        return data;
    }

    public void setData(WeatherData data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Rc getRc() {
        return rc;
    }

    public void setRc(Rc rc) {
        this.rc = rc;
    }








}
