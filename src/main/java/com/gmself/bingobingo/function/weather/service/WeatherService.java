package com.gmself.bingobingo.function.weather.service;

import com.gmself.bingobingo.function.weather.entity.HFWeatherForecast;
import com.gmself.bingobingo.function.weather.entity.HfWeatherNow;

public interface WeatherService {

    void insertWeather(HFWeatherForecast weather);

    void requestWeatherForecast(String location);

    void requestWeatherNow(String location);

    void insertWeather(HfWeatherNow weather);

    void updateWeatherAll(String location);
}
