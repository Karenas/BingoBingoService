package com.gmself.bingobingo.module.subject.aop;

import com.gmself.bingobingo.module.subject.entity.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.util.StringUtils;

@Aspect
public class SubjectAspect {

    @Pointcut("execution(* com.gmself.bingobingo.module.subject.service.SubjectServiceImpl.punchUser(..))")
    public void pointCut(){
    }

    @Before("pointCut() && args(user)")
    public void before(User user){
        System.out.println("AOP --- before() ");
    }

    @Around(value = "pointCut() && args(user)")
    public int around(ProceedingJoinPoint pjp, User user) throws  Throwable{
        if (checkUser(user)){
            pjp.proceed();
            return 1111;
        }
        return 2222;
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

    private boolean checkUser(User user){
        if (null != user){
            return true;
        }
        return false;
    }
}
