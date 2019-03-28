package com.gmself.bingobingo.function.timerTask;

import com.gmself.bingobingo.function.weather.WeatherManager;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimerTaskManager {

    private static TimerTaskManager instance = new TimerTaskManager();

    public static TimerTaskManager getInstance(){
        return instance;
    }

    public void run(){
        Runnable runnable = new Runnable() {
            public void run() {
                WeatherManager.HttpTestJJ3("2");//北京
            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(runnable, 0, 24, TimeUnit.HOURS);
    }

}
