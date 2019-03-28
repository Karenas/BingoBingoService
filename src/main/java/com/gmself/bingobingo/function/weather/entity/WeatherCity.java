package com.gmself.bingobingo.function.weather.entity;

public class WeatherCity{
        private int cityId;
        private String counname;
        private String ianatimezone;
        private String name;
        private String pname;
        private String timezone;

        public int getCityId() {
            return cityId;
        }

        public void setCityId(int cityId) {
            this.cityId = cityId;
        }

        public String getCounname() {
            return counname;
        }

        public void setCounname(String counname) {
            this.counname = counname;
        }

        public String getIanatimezone() {
            return ianatimezone;
        }

        public void setIanatimezone(String ianatimezone) {
            this.ianatimezone = ianatimezone;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPname() {
            return pname;
        }

        public void setPname(String pname) {
            this.pname = pname;
        }

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }
    }