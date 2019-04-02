package com.gmself.bingobingo.function.statistics.service;

import com.gmself.bingobingo.function.statistics.UserLocationStatisticsMapper;
import com.gmself.bingobingo.function.statistics.entity.UserLocationStatistics;
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

        UserLocationStatistics statistics = userLocationStatisticsMapper.selectByLocationID(locationId);
        if (null == statistics){
            statistics = new UserLocationStatistics();
            statistics.setLocationId(locationId);
            statistics.setTotalCount(1);
            statistics.setValidCount(1);
            userLocationStatisticsMapper.insertSelective(statistics);
        }else {
            statistics.setTotalCount(statistics.getTotalCount());
            statistics.setValidCount(statistics.getValidCount());
            userLocationStatisticsMapper.updateByLocationID(statistics);
        }
    }
}
