package com.rms.rentalmanagementsystem.log;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingTracker {
    @Pointcut("within(com.rms.rentalmanagementsystem.service.*)")
    public void pointCut(){

    }
    //Execute this method before every method of service
    @Before("pointCut()")
    public void logBefore(){
        System.out.println("Method Started!");
    }
    //Execute this method after every method of service
    @After("pointCut()")
    public void logAfter(){
        System.out.println("Method Executed!");
    }
}
