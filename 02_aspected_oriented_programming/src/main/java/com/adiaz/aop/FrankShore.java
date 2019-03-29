package com.adiaz.aop;

import org.springframework.stereotype.Component;

@Component
public class FrankShore implements Performance {

    @Override
    public void perform() throws Exception {
        System.out.println("**Asi soy yo....");
        throw new Exception("Desafine brutal");
    }
}
