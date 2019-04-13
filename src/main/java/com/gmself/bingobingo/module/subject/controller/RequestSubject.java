package com.gmself.bingobingo.module.subject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.gmself.bingobingo.function.statistics.service.StatisticsService;
import com.gmself.bingobingo.function.weather.entity.HFWeatherForecast;
import com.gmself.bingobingo.function.weather.entity.HfWeatherNow;
import com.gmself.bingobingo.function.weather.service.WeatherService;
import com.gmself.bingobingo.module.subject.constant.CheckCode_subject;
import com.gmself.bingobingo.module.subject.constant.RespCode_getWeatherForecast;
import com.gmself.bingobingo.module.subject.constant.RespCode_getWeatherNow;
import com.gmself.bingobingo.module.subject.constant.RespCode_punch;
import com.gmself.bingobingo.module.subject.entity.User;
import com.gmself.bingobingo.module.subject.entity.resp.RespGetWeatherForecast;
import com.gmself.bingobingo.module.subject.entity.resp.RespGetWeatherNow;
import com.gmself.bingobingo.module.subject.entity.resp.RespPunch;
import com.gmself.bingobingo.module.subject.service.SubjectService;
import com.gmself.bingobingo.responseEntity.RespMessage;
import com.gmself.bingobingo.responseEntity.Resp_processWrongType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "/m_subject", method = RequestMethod.POST)
public class RequestSubject {

    @Autowired
    private SubjectService subjectService = null;

    @Autowired
    private StatisticsService statisticsService = null;

    @Autowired
    private WeatherService weatherService = null;

    @PostMapping(value = "/requestWeatherForecast")
    public void requestWeatherForecast(HttpServletRequest request, HttpServletResponse response, @RequestBody String jsonParam)
    {
        String cityID = JSON.parseObject(jsonParam).getString("cityID");
        RespMessage respMessage = new RespMessage();
        RespGetWeatherForecast respGetWeatherForecast = null;
        if (StringUtils.isEmpty(cityID)){
            respGetWeatherForecast = new RespGetWeatherForecast(RespCode_getWeatherForecast.NO_CITY_ID, "cityID为空");
        }

        List<HFWeatherForecast> weatherForecasts = null;

        if (null == respGetWeatherForecast){
            weatherForecasts = subjectService.getWeatherForecast(cityID);
            if (weatherForecasts == null || weatherForecasts.size() == 0){
                respMessage.setProcessResult(false);
                respMessage.setProcessWrong(Resp_processWrongType.GENERAL);
                respGetWeatherForecast = new RespGetWeatherForecast(RespCode_getWeatherForecast.NO_DATA, "未获取到相关数据，请稍后再试");
                statisticsService.recordUserLocation(cityID);
                weatherService.updateWeatherAll(cityID);
            }
        }

        if (null == respGetWeatherForecast){
            respMessage.setProcessResult(true);
            respGetWeatherForecast = new RespGetWeatherForecast(RespCode_getWeatherNow.SUCCESS, "数据获取成功");
            respGetWeatherForecast.setWeatherForecasts(weatherForecasts);
        }

        respMessage.setResult(respGetWeatherForecast);

        writeResult(response, respMessage);
    }

    @PostMapping(value = "/requestWeatherNow")
    public void requestWeatherNow(HttpServletRequest request, HttpServletResponse response, @RequestBody String jsonParam)
    {

        String cityID = JSON.parseObject(jsonParam).getString("cityID");
        RespMessage respMessage = new RespMessage();
        RespGetWeatherNow respGetWeatherNow = null;
        if (StringUtils.isEmpty(cityID)){
            respGetWeatherNow = new RespGetWeatherNow(RespCode_getWeatherNow.NO_CITY_ID, "cityID为空");
        }

        HfWeatherNow weatherNow = null;

        if (null == respGetWeatherNow){
            weatherNow = subjectService.getWeatherNow(cityID);
            if (weatherNow == null){
                respMessage.setProcessResult(false);
                respMessage.setProcessWrong(Resp_processWrongType.GENERAL);
                respGetWeatherNow = new RespGetWeatherNow(RespCode_getWeatherNow.NO_DATA, "未获取到相关数据，请稍后再试");
                statisticsService.recordUserLocation(cityID);
                weatherService.updateWeatherAll(cityID);
            }
        }

        if (null == respGetWeatherNow){
            respMessage.setProcessResult(true);
            respGetWeatherNow = new RespGetWeatherNow(RespCode_getWeatherNow.SUCCESS, "数据获取成功");
            respGetWeatherNow.setWeatherNow(weatherNow);
        }

        respMessage.setResult(respGetWeatherNow);

        writeResult(response, respMessage);
    }


    /**
     * 用户打卡
     * */
    @PostMapping(value = "/punch")
    public void doPunchUser(HttpServletRequest request, HttpServletResponse response, @RequestBody User user)
    {
        RespMessage respMessage = new RespMessage();
        RespPunch respPunch = null;
        CheckCode_subject code = user.checkParam();

        switch (code){
            case ERROR_NO_PHONENUMBER:
                respPunch = new RespPunch(RespCode_punch.NO_PHONE_NUMBER,
                        "手机号码为空");
                break;
            case ERROR_NO_DEVICE_ID:
                respPunch = new RespPunch(RespCode_punch.NO_DEVICE_ID,
                        "设备ID为空");
                break;
        }

        if (null == respPunch){
            int punchResult = subjectService.punchUser(user);
            if (punchResult == RespCode_punch.DATABASE_FAIL){
                respMessage.setProcessResult(false);
                respMessage.setProcessWrong(Resp_processWrongType.WRONG_DATABASE);
                respPunch = new RespPunch(RespCode_punch.DATABASE_FAIL, "数据库写入错误");
            }
        }

        if (null == respPunch){
            respMessage.setProcessResult(true);
            respPunch = new RespPunch(RespCode_punch.SUCCESS, "打卡接口数据处理成功 统计表已更新 用户记录表已更新");
            statisticsService.recordUserLocation(user.getLastLocationId());
        }
        respMessage.setResult(respPunch);

        writeResult(response, respMessage);
    }

//    public void

    private void writeResult(HttpServletResponse response,  RespMessage result){
        if (!result.checkValid()){
            return;
        }
        String resp = JSON.toJSONString(result, SerializerFeature.WriteMapNullValue);

        try {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
