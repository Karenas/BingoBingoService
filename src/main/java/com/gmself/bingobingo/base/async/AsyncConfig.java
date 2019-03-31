package com.gmself.bingobingo.base.async;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync //开启spring异步
public class AsyncConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(10);//核心线程数
        taskExecutor.setMaxPoolSize(30);//最大线程数
        taskExecutor.setQueueCapacity(1500); //线程队列最大线程数
        taskExecutor.initialize();
        return taskExecutor;
    }
}
