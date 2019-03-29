package com.gmself.bingobingo.function.weather.service.Impl;

import com.gmself.bingobingo.base.ApplicationContextProvider;
import com.gmself.bingobingo.base.CommonDao;
import com.gmself.bingobingo.function.weather.service.WeatherService;
import com.gmself.bingobingo.module.subject.db.dao.WeatherMapper;
import com.gmself.bingobingo.module.subject.entity.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl extends CommonDao implements WeatherService {
    @Autowired
    private WeatherMapper weatherMapper;

    @Override
    public void insertWeather(Weather weather) {
        if (null == weatherMapper){
            weatherMapper = ApplicationContextProvider.getBean(WeatherMapper.class);
        }
        int r = weatherMapper.update(weather);
        if (r<=0){
            weatherMapper.insertSelective(weather);
        }
    }
}
