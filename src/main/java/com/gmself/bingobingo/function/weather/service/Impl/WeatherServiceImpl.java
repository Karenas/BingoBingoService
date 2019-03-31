package com.gmself.bingobingo.function.weather.service.Impl;

import com.gmself.bingobingo.base.ApplicationContextProvider;
import com.gmself.bingobingo.base.CommonDao;
import com.gmself.bingobingo.function.weather.HFWeatherMapper;
import com.gmself.bingobingo.function.weather.HeFengWeatherHandler;
import com.gmself.bingobingo.function.weather.entity.HFWeatherForecast;
import com.gmself.bingobingo.function.weather.entity.HFWeatherForecast;
import com.gmself.bingobingo.function.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl extends CommonDao implements WeatherService {
    @Autowired
    private HFWeatherMapper weatherMapper;

    @Override
    public void insertWeather(HFWeatherForecast weather) {
        if (null == weatherMapper){
            weatherMapper = ApplicationContextProvider.getBean(HFWeatherMapper.class);
        }
        int r = weatherMapper.updateForecast(weather);
        if (r<=0){
            weatherMapper.insertForecast(weather);
        }
    }

    @Override
    public void requestWeather(String location) {
        HeFengWeatherHandler.getInstance().requestWeather(location);
    }



}
