package com.gmself.bingobingo.function.weather.service;

import com.gmself.bingobingo.function.weather.entity.HFWeatherForecast;

public interface WeatherService {

    void insertWeather(HFWeatherForecast weather);

    void requestWeather(String location);


}
