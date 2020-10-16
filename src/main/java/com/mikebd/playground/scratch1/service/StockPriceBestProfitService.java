package com.mikebd.playground.scratch1.service;

import com.mikebd.playground.scratch1.util.test.TestData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * See: https://algorithms.tutorialhorizon.com/stock-single-sell-problem-on-solution/
 */
@Service
@Slf4j
public class StockPriceBestProfitService {
    public boolean run() {
        log.info("Start StockPriceBestProfitService");
        boolean pass = true;
        pass &= testData1.test(StockPriceBestProfitService::test);
        pass &= testData2.test(StockPriceBestProfitService::test);
        pass &= testData3.test(StockPriceBestProfitService::test);
        if (pass) {
            log.info("Overall: PASS");
        } else {
            log.info("Overall: FAIL");
        }
        log.info("End StockPriceBestProfitService");
        return pass;
    }

    public static boolean test(final long[] input, final long expected) {
        final long actual = calculate(input);
        final boolean pass = expected == actual;
        final String logMessage = (pass ? "PASS " : "FAIL ") + Arrays.toString(input) + " expect " + expected + " = " + actual;
        if (pass) log.info(logMessage); else log.error(logMessage);
        return pass;
    }

    // Oddly, test cases expect negative stock prices to be considered normal
    private static long calculate(long[] prices) {
        if (prices == null || prices.length == 0) return 0;

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

    static final TestData<long[], Long> testData1 = new TestData<>(new long[] {13, 10, 8, 4, 10}, 6L);
    static final TestData<long[], Long> testData2 = new TestData<>(new long[] {6, 0, -1, 10}, 11L);
    static final TestData<long[], Long> testData3 = new TestData<>(new long[] {5, 10, 20, 30, 1, 0}, 25L);
}