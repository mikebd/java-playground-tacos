package com.mikebd.playground.scratch1.service;

import com.mikebd.playground.scratch1.util.test.TestData;
import com.mikebd.playground.scratch1.util.test.TestDataList;
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
        final boolean pass = testDataList.test(StockPriceBestProfitService::test, log);
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

    static final TestDataList<long[], Long> testDataList = new TestDataList<>();
    static {
        final var list = testDataList.getList();
        list.add(new TestData<>(new long[] {13, 10, 8, 4, 10}, 6L));
        list.add(new TestData<>(new long[] {6, 0, -1, 10}, 11L));
        list.add(new TestData<>(new long[] {5, 10, 20, 30, 1, 0}, 25L));
    }
}