package com.mikebd.playground.scratch1;

import com.mikebd.playground.scratch1.service.StockPriceBestProfitService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@AllArgsConstructor
@SpringBootApplication
@Slf4j
public class Scratch1Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Scratch1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Start");
        stockPriceBestProfitService.run();
        log.info("End");
        // SpringApplication.exit();
    }

    private final StockPriceBestProfitService stockPriceBestProfitService;
}