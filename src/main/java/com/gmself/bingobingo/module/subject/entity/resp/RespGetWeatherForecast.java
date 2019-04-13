package com.gmself.bingobingo.module.subject.entity.resp;

import com.gmself.bingobingo.function.weather.entity.HFWeatherForecast;
import com.gmself.bingobingo.function.weather.entity.HfWeatherNow;
import com.gmself.bingobingo.responseEntity.Resp_result;

import java.util.List;

public class RespGetWeatherForecast extends Resp_result{

    private int code;
    private String msg;

    private List<HFWeatherForecast> weatherForecasts;

    public RespGetWeatherForecast(int code, String msg) {
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

    public List<HFWeatherForecast> getWeatherForecasts() {
        return weatherForecasts;
    }

    public void setWeatherForecasts(List<HFWeatherForecast> weatherForecasts) {
        this.weatherForecasts = weatherForecasts;
    }
}
