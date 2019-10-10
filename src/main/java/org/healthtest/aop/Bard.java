package org.healthtest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Bard {

//    @Pointcut("execution(* org.healthtest.service.impl.KnightServiceImp.getAchievement(..))")
//    public void serviceBefore() {
//
//    }
//
//    @Before("serviceBefore()")
//    public void getSong(JoinPoint joinPoint) {
//        System.out.println("LALALAlalaaalala");
//    }
    @Around("execution(* org.healthtest.service.KnightService.getAchievement(..)) && args(val, ..)")
    public Object action(ProceedingJoinPoint joinPoint, String val) throws Throwable {
        long timeBefore = System.currentTimeMillis();
        Object obj = joinPoint.proceed();
        System.out.println("LAlalalalala");


        long timeAfter = System.currentTimeMillis();
        System.out.println("Knight defeat an enemy - " + val + " with " + ((timeAfter - timeBefore) / 1000) + "s");
        return obj;
    }
}
