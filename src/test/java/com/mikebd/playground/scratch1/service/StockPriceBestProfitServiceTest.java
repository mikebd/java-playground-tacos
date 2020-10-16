package com.mikebd.playground.scratch1.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StockPriceBestProfitServiceTest {
    @Test
    void test() {
        assertTrue(StockPriceBestProfitService.testData1.test(StockPriceBestProfitService::test));
        assertTrue(StockPriceBestProfitService.testData2.test(StockPriceBestProfitService::test));
        assertTrue(StockPriceBestProfitService.testData3.test(StockPriceBestProfitService::test));
    }
}