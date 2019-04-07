package com.gmself.bingobingo.function.weather;

//https://www.heweather.com/documents/sdk/java

import com.gmself.bingobingo.base.ApplicationContextProvider;
import com.gmself.bingobingo.function.weather.entity.HFWeatherForecast;
import com.gmself.bingobingo.function.weather.service.WeatherServiceImpl;
import com.gmself.bingobingo.function.weather.service.WeatherService;
import com.heweather.sdk.api.HeConfig;
import com.heweather.sdk.api.HeWeather;
import com.heweather.sdk.bean.Lang;
import com.heweather.sdk.bean.Unit;
import com.heweather.sdk.bean.weather.forecast.Forecast;
import com.heweather.sdk.bean.weather.forecast.ForecastBase;
import com.heweather.sdk.bean.weather.now.Now;
import com.heweather.sdk.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HeFengWeatherHandler {
    private static HeFengWeatherHandler instance = new HeFengWeatherHandler();

    public static HeFengWeatherHandler getInstance(){
        return instance;
    }

    public HeFengWeatherHandler() {
        HeConfig.init("HE1903300900091525", "20f8afaeaf5a4086b830553772916967");
        HeConfig.switchToFreeServerNode();
    }

    @Autowired
    private WeatherService weatherService;

    public void requestWeatherForecast(String location){
        if (null == weatherService){
            weatherService = ApplicationContextProvider.getBean(WeatherServiceImpl.class);
        }

        HeWeather.s6Forecast(location, Lang.CHINESE_SIMPLIFIED, Unit.METRIC, new Callback<List<Forecast>>() {
            @Override
            public void onSuccess(List<Forecast> forecasts) {
                forecastList2WeatherDB(forecasts);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });

    }

    public void requestWeatherNow(String location){
        if (null == weatherService){
            weatherService = ApplicationContextProvider.getBean(WeatherServiceImpl.class);
        }

//        /**
//         * 实况天气
//         * 实况天气即为当前时间点的天气状况以及温湿风压等气象指数，具体包含的数据：体感温度、
//         * 实测温度、天气状况、风力、风速、风向、相对湿度、大气压强、降水量、能见度等。
//         *
//         * @param location (必填)城市 ID, 经纬度(经度在前，纬度在后，以高德经纬度为准)，Adcode, 名称，IP（精度不高）
//         * @param lang     (选填)多语言，可以不使用该参数，默认为简体中文
//         * @param unit     (选填)单位选择，公制（m）或英制（i），默认为公制单位
//         * @param callback 网络访问回调接口
//         */
        HeWeather.s6Now(location, Lang.CHINESE_SIMPLIFIED, Unit.METRIC, new Callback<List<Now>>() {
            @Override
            public void onSuccess(List<Now> nows) {
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }

    @Transactional
    public void forecastList2WeatherDB(List<Forecast> forecasts){
        if (null == forecasts){
            return;
        }

        for (Forecast forecast : forecasts) {
            forecast2Weather(forecast);
        }
    }

    private void forecast2Weather(Forecast forecast){
        if (forecast == null){
            return;
        }
        String cityID = forecast.getBasic().getCid();
        String update = forecast.getUpdate().getLoc();

        HFWeatherForecast weather;
        for (ForecastBase forecastBase : forecast.getDaily_forecast()) {
            weather = new HFWeatherForecast(cityID, update);
            weather.setDate(forecastBase.getDate());
            weather.setCond_code_d(forecastBase.getCond_code_d());
            weather.setCond_code_n(forecastBase.getCond_code_n());
            weather.setCond_txt_d(forecastBase.getCond_txt_d());
            weather.setCond_txt_n(forecastBase.getCond_txt_n());
            weather.setHum(forecastBase.getHum());
            weather.setMr(forecastBase.getMr());
            weather.setMs(forecastBase.getMs());
            weather.setPcpn(forecastBase.getPcpn());
            weather.setPop(forecastBase.getPop());
            weather.setPres(forecastBase.getPres());
            weather.setSr(forecastBase.getSr());
            weather.setSs(forecastBase.getSs());
            weather.setTmp_max(forecastBase.getTmp_max());
            weather.setTmp_min(forecastBase.getTmp_min());
            weather.setUv_index(forecastBase.getUv_index());
            weather.setVis(forecastBase.getVis());
            weather.setWind_deg(forecastBase.getWind_deg());
            weather.setWind_dir(forecastBase.getWind_dir());
            weather.setWind_sc(forecastBase.getWind_sc());
            weather.setWind_spd(forecastBase.getWind_spd());

            weatherService.insertWeather(weather);
        }


    }

}
