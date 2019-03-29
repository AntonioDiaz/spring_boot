package com.adiaz.aop;

import org.springframework.stereotype.Component;

@Component
public class Smiths implements Performance {

    @Override
    public void perform() {
        System.out.println("**Hang the DJ, hang the DJ, hang the DJ!!!");
    }
}
