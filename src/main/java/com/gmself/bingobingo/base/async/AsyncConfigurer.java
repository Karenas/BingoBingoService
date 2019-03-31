package com.gmself.bingobingo.base.async;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.lang.Nullable;

import java.util.concurrent.Executor;

public interface AsyncConfigurer {

    @Nullable
    default Executor getAsyncExecutor(){
        return null;
    }

    @Nullable
    default AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler(){
        return  null;
    }



}
