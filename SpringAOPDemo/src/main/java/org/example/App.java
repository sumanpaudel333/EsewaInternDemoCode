package org.example;

import org.example.aop.service.PaymentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("config.xml");
        PaymentService paymentService= (PaymentService) applicationContext.getBean("payment");
        paymentService.makePayment(2000);
    }
}
