package com.gmself.bingobingo.module.subject.aop;

import com.gmself.bingobingo.module.subject.entity.User;
import org.aspectj.lang.annotation.*;

@Aspect
public class SubjectAspect {

    @Pointcut("execution(* com.gmself.bingobingo.module.subject.service.Impl.SubjectServiceImpl.PunchUser(..))")
    public void pointCut(){
    }

    @Before("pointCut() && args(user)")
    public void before(User user){
        System.out.println("AOP --- before() ");
    }

    @After("pointCut()")
    public void after(){
        System.out.println("AOP --- after() ");

    }

    @AfterReturning("pointCut()")
    public void afterReturning(){
        System.out.println("AOP --- afterReturning() ");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        System.out.println("AOP --- afterThrowing() ");

    }
}
