package com.gmself.bingobingo.function.statistics.service;

import com.gmself.bingobingo.function.statistics.entity.UserLocationStatistics;

import java.util.List;

public interface StatisticsService {

    //提交用户使用地点到数据库
    void recordUserLocation(String locationId);

    List<UserLocationStatistics> getAllLocationStatistics();

}
