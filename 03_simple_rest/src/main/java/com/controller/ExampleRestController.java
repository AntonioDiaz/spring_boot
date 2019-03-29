package com.controller;

import com.model.Song;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleRestController {

    @GetMapping("hello")
    public String sayHello() {
        return "hello";
    }

    @GetMapping("hitsong")
    public Song getSong() {
        return new Song(1, "toma ", "author");
    }
}
