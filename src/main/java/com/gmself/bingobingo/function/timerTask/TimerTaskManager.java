package com.gmself.bingobingo.function.timerTask;

import com.gmself.bingobingo.function.weather.WeatherManager;
import com.gmself.bingobingo.util.date_tool.DateTools;
import com.sun.javaws.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.gmself.bingobingo.util.date_tool.DateTools.getCurrentTime;

public class TimerTaskManager {

    private static TimerTaskManager instance = new TimerTaskManager();

    public static TimerTaskManager getInstance(){
        return instance;
    }


    public void run(){
        int planningH = 6;
        int planningM = 0;

        Calendar c = DateTools.getCurrentTime();
        int h = c.get(Calendar.HOUR_OF_DAY);
        int m =  c.get(Calendar.MINUTE);

        int subH = planningH - h;
        int subM = planningM - m;

        int subMinT = subH > 0? subH*60 + subM : (24+subH)*60 + subM;

        Runnable runnable = new Runnable() {
            public void run() {
                WeatherManager.getInstance().HttpJJ3("2");//北京
            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(runnable, subMinT, 24 * 60, TimeUnit.MINUTES);
    }

}
