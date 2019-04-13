package com.gmself.bingobingo.module.subject.service;


import com.gmself.bingobingo.function.weather.entity.HFWeatherForecast;
import com.gmself.bingobingo.function.weather.entity.HfWeatherNow;
import com.gmself.bingobingo.module.subject.entity.User;

import java.util.List;

public interface SubjectService {

    //用户打卡
    int punchUser(User user);

    HfWeatherNow getWeatherNow(String cityID);

    List<HFWeatherForecast> getWeatherForecast(String cityID);

    User getUserByPhoneNumber(String phoneNumber);

}
