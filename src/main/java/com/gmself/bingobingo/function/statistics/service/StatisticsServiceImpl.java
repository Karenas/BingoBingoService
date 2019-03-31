package com.gmself.bingobingo.function.statistics.service;

import com.gmself.bingobingo.function.statistics.UserLocationStatisticsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private UserLocationStatisticsMapper userLocationStatisticsMapper;

    @Override
    @Async //异步
    public void recordUserLocation(String locationId) {
        //TODO 对使用地点统计表中做出修改
    }
}
