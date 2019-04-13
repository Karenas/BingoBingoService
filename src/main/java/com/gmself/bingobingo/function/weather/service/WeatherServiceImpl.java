package com.gmself.bingobingo.function.weather.service;

import com.gmself.bingobingo.base.ApplicationContextProvider;
import com.gmself.bingobingo.base.CommonDao;
import com.gmself.bingobingo.function.weather.HFWeatherForecastMapper;
import com.gmself.bingobingo.function.weather.HeFengWeatherHandler;
import com.gmself.bingobingo.function.weather.HfWeatherNowMapper;
import com.gmself.bingobingo.function.weather.entity.HFWeatherForecast;
import com.gmself.bingobingo.function.weather.entity.HFWeatherForecast;
import com.gmself.bingobingo.function.weather.entity.HfWeatherNow;
import com.gmself.bingobingo.function.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WeatherServiceImpl extends CommonDao implements WeatherService {
    @Autowired
    private HFWeatherForecastMapper forecastMapper;

    @Autowired
    private HfWeatherNowMapper nowMapper;

    @Override
    public void insertWeather(HFWeatherForecast weather) {
        if (null == forecastMapper){
            forecastMapper = ApplicationContextProvider.getBean(HFWeatherForecastMapper.class);
        }
        int r = forecastMapper.updateForecast(weather);
        if (r<=0){
            forecastMapper.insertForecast(weather);
        }
    }

    @Override
    public void requestWeatherForecast(String location) {
        HeFengWeatherHandler.getInstance().requestWeatherForecast(location);
    }

    @Override
    public void requestWeatherNow(String location) {
        HeFengWeatherHandler.getInstance().requestWeatherNow(location);
    }

    @Override
    public void insertWeather(HfWeatherNow weather) {
        if (null == nowMapper){
            nowMapper = ApplicationContextProvider.getBean(HfWeatherNowMapper.class);
        }
        int r = nowMapper.updateNow(weather);
        if (r<=0){
            nowMapper.insertNow(weather);
        }
    }

    @Async
    @Override
    public void updateWeatherAll(String location) {
        requestWeatherForecast(location);
        requestWeatherNow(location);
    }


}
