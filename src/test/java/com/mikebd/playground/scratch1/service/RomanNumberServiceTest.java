package com.mikebd.playground.scratch1.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class RomanNumberServiceTest {
    @Test
    void test() {
        assertTrue(RomanNumberService.testDataList.test(RomanNumberService::test, log));
    }
}