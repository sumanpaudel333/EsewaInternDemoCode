package org.example.aop.aspect;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
    /* (..) is used for parameterized method that requires argument whereas * is used
    for representing any return type of method*/
    @Before("execution(* org.example.aop.service.PaymentServiceImpl.makePayment(..))")
    public void printBefore(){
        System.out.println("Payment Started!");
    }
    @After("execution(* org.example.aop.service.PaymentServiceImpl.makePayment(..))")
    public void printAfter(){
        System.out.println("Payment Done!");
    }
}

