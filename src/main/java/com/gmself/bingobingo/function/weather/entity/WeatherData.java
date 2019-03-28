package com.gmself.bingobingo.function.weather.entity;

import java.util.List;

public class WeatherData {
        private WeatherCity city;
        private List<Forecast> forecast;

        public WeatherCity getCity() {
            return city;
        }

        public void setCity(WeatherCity city) {
            this.city = city;
        }

        public List<Forecast> getForecast() {
            return forecast;
        }

        public void setForecast(List<Forecast> forecast) {
            this.forecast = forecast;
        }
    }