package com.gmself.bingobingo.function.timerTask;

import com.gmself.bingobingo.base.ApplicationContextProvider;
import com.gmself.bingobingo.function.weather.service.Impl.WeatherServiceImpl;
import com.gmself.bingobingo.function.weather.service.WeatherService;
import com.gmself.bingobingo.util.date_tool.DateTools;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
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

    public void run(){
        if (null == weatherService){
            weatherService = ApplicationContextProvider.getBean(WeatherServiceImpl.class);
        }

        int planningH = 12;
        int planningM = 0;

        Calendar c = DateTools.getCurrentTime();
        int h = c.get(Calendar.HOUR_OF_DAY);
        int m =  c.get(Calendar.MINUTE);

        int subH = planningH - h;
        int subM = planningM - m;

        int subMinT = subH > 0? subH*60 + subM : (24+subH)*60 + subM;

        Runnable runnable = new Runnable() {
            public void run() {

                weatherService.requestWeather("CN101010100");
            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(runnable, subMinT,  60, TimeUnit.MINUTES);
    }

}
