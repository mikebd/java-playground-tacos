package com.mikebd.playground.scratch1.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class FibonacciServiceTest {
    @Test
    void test() {
        assertTrue(FibonacciService.testDataList.test(FibonacciService::test, log));
    }
}