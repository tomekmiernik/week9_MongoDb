package com.example.week9.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Aspect
@Component
public class TimerAspect {
    private long startTime;
    private long finishTime;
    private long resultTime;

    @Around("@annotation(WhatActionTime)")
    public void runCount(ProceedingJoinPoint joinPoint) throws Throwable {
        startTime = System.currentTimeMillis();
        joinPoint.proceed();
        finishTime = System.currentTimeMillis();
        resultTime = finishTime - startTime;
    }

    public long getResultTime() {
        return resultTime;
    }
}
