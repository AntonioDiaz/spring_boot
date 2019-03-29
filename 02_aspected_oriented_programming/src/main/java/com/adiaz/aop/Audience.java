package com.adiaz.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class Audience {

    @Pointcut("execution(* com.adiaz.aop.Performance.perform(..))")
    public void performance() {

    }

    @Before("performance()")
    public void silencePhones() {
        System.out.println("silencing phones");
    }

    @AfterReturning("performance()")
    public void clap() {
        System.out.println("PLAS PLAS PLAS!!!");
    }

    @AfterReturning("performance()")
    public void askBis() {
        System.out.println("Otres tres, otres tres!!!");
    }

    @AfterThrowing("performance()")
    public void boo() {
        System.out.println("boo and tomatoes!!!");
    }
}
