package com.adiaz.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    Smiths smiths;

    @Autowired
    FrankShore frankShore;


    @Override
    public void run(String... args) {
        smiths.perform();
        try {
            frankShore.perform();
        } catch (Exception e) {
            System.out.println("exception catch ...");
        }


    }
}
