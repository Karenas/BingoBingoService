package com.gmself.bingobingo.module.subject.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.gmself.bingobingo.function.statistics.service.StatisticsService;
import com.gmself.bingobingo.function.weather.service.WeatherService;
import com.gmself.bingobingo.module.subject.constant.CheckCode_subject;
import com.gmself.bingobingo.module.subject.constant.RespCode_punch;
import com.gmself.bingobingo.module.subject.entity.User;
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

@Controller
@RequestMapping(value = "/m_subject", method = RequestMethod.POST)
public class RequestSubject {

    @Autowired
    private SubjectService subjectService = null;

    @Autowired
    private StatisticsService statisticsService = null;

    @PostMapping(value = "/requestWeather")
    public void requestWeather(HttpServletRequest request, HttpServletResponse response, @RequestBody User user)
    {

    }


    /**
     * 用户打开
     * */
    @PostMapping(value = "/punch")
    public void doPunchUser(HttpServletRequest request, HttpServletResponse response, @RequestBody User user)
    {
        user = new User();
        user.setDeviceId("333333333");
        user.setDeviceId("dddddddddddddd");
        user.setPhoneNumber("132222222222");

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
