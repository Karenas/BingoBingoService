package com.gmself.bingobingo.function.timerTask;

import com.gmself.bingobingo.base.ApplicationContextProvider;
import com.gmself.bingobingo.function.statistics.entity.UserLocationStatistics;
import com.gmself.bingobingo.function.statistics.service.StatisticsService;
import com.gmself.bingobingo.function.statistics.service.StatisticsServiceImpl;
import com.gmself.bingobingo.function.weather.service.WeatherServiceImpl;
import com.gmself.bingobingo.function.weather.service.WeatherService;
import com.gmself.bingobingo.util.date_tool.DateTools;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimerTaskManager {

    private static TimerTaskManager instance = new TimerTaskManager();

    public static TimerTaskManager getInstance(){
        return instance;
    }

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private StatisticsService statisticsService;

    private boolean isReqWeatherForecast = false;

    public void runWeatherTask(){
        if (null == weatherService){
            weatherService = new WeatherServiceImpl();
        }

        if (null == statisticsService){
            statisticsService = new StatisticsServiceImpl();
        }

        int planningH = 6;
        int planningM = 0;

        Calendar c = DateTools.getCurrentTime();
        int h = c.get(Calendar.HOUR_OF_DAY);
        int m =  c.get(Calendar.MINUTE);

        int subH = planningH - h;
        int subM = planningM - m;

        int subMinT = subH > 0? subH*60 + subM : (24+subH)*60 + subM;

        Runnable runnable = () -> {
            List<UserLocationStatistics> locationStatistics = statisticsService.getAllLocationStatistics();
            if (null != locationStatistics && locationStatistics.size() > 0){
                for (UserLocationStatistics loc : locationStatistics) {
                    weatherService.requestWeatherNow(loc.getLocationId());

                    if (isReqWeatherForecast){
                        weatherService.requestWeatherForecast(loc.getLocationId());
                    }
                }
            }

            isReqWeatherForecast = !isReqWeatherForecast;
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(runnable, subMinT,  60, TimeUnit.MINUTES);
    }

}
