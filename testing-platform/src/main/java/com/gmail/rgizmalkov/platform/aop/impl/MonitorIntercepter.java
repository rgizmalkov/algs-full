package com.gmail.rgizmalkov.platform.aop.impl;

import com.gmail.rgizmalkov.platform.aop.annlotations.Monitor;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by romanizmalkov on 20.02.17.
 */

@Aspect
public class MonitorIntercepter {
    private static final Logger LOG = Logger.getLogger(MonitorIntercepter.class);

    @Pointcut("@annotation(monitor)")
    public void pointcutMonitor(Monitor monitor){}

    @Around("pointcutMonitor(monitor) && execution(* *(..))")
    public Object aroundMethodWithMonitor(ProceedingJoinPoint jp, Monitor monitor) throws Throwable {
        LOG.info("Algorithm in progress: " + jp.getSignature().getDeclaringType());
        return jp.proceed();
    }
}
