package com.mikebd.playground.scratch1.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StockPriceBestProfitServiceTest {
    @Test
    void test() {
        assertTrue(StockPriceBestProfitService.test(StockPriceBestProfitService.testData1));
        assertTrue(StockPriceBestProfitService.test(StockPriceBestProfitService.testData2));
        assertTrue(StockPriceBestProfitService.test(StockPriceBestProfitService.testData3));
    }
}