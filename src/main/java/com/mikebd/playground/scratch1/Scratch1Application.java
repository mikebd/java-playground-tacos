package com.mikebd.playground.scratch1;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@AllArgsConstructor
@SpringBootApplication
@Slf4j
public class Scratch1Application {

    public static void main(String[] args) {
        SpringApplication.run(Scratch1Application.class, args);
    }
}