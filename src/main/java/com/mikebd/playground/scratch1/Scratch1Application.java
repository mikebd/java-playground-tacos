package com.mikebd.playground.scratch1;

import com.mikebd.playground.scratch1.service.StockPriceBestProfitService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

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
        final boolean pass = stockPriceBestProfitService.run();
        log.info("End");
        System.exit(SpringApplication.exit(ctx, () -> pass ? 0 : 1));
    }

    private final ApplicationContext ctx;
    private final StockPriceBestProfitService stockPriceBestProfitService;
}