package com.mikebd.playground.scratch1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class Scratch1Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Scratch1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Start");
        runStockPriceBestProfit();
        log.info("End");
        // SpringApplication.exit();
    }

    private static void runStockPriceBestProfit() {
        boolean pass = true;
        pass &= testStockPriceBestProfit(new long [] {13, 10, 8, 4, 10}, 6);
        pass &= testStockPriceBestProfit(new long [] {6, 0, -1, 10}, 11);
        pass &= testStockPriceBestProfit(new long [] {5, 10, 20, 30, 1, 0}, 25);
        if (pass) {
            log.info("Overall: PASS");
        } else {
            log.info("Overall: FAIL");
        }
    }

    private static boolean testStockPriceBestProfit(final long[] input, final long expected) {
        final long actual = calcStockPriceBestProfit(input);
        final boolean pass = expected == actual;
        if (pass) {
            log.info("PASS " + Arrays.toString(input) + " expect " + expected + " = " + actual);
        } else {
            log.error("FAIL " + Arrays.toString(input) + " expect " + expected + " = " + actual);
        }
        return pass;
    }

    private static long calcStockPriceBestProfit(long[] prices) {
        if (prices == null || prices.length == 0) return 0;

        // Oddly, test cases expect negative stock prices to be considered normal
        final int maxIndex = prices.length - 1;

        // Init to conditions on the final day
        long profit = 0;
        long sellPrice = prices[maxIndex];

        // O(n) - reverse traversal to ensure the maximum sell price always occurs after the current buying opportunity
        for (int index = maxIndex - 1; index >= 0; --index) {
            final long price = prices[index];
            sellPrice = Math.max(sellPrice, price);
            final long potentialProfit = sellPrice - price;
            profit = Math.max(profit, potentialProfit);
        }

        return profit;
    }
}