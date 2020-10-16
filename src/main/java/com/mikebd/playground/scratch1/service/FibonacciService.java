package com.mikebd.playground.scratch1.service;

import com.mikebd.playground.scratch1.util.test.TestData;
import com.mikebd.playground.scratch1.util.test.TestDataList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * See: https://algorithms.tutorialhorizon.com/print-first-n-numbers-in-fibonacci-series/
 * 0 1 1 2 3 5 8 13 21 34 55 89 ...
 */
@Service
@Slf4j
public class FibonacciService {
    public boolean run() {
        log.info("Start FibonacciService");
        final boolean pass = testDataList.test(FibonacciService::test, log);
        log.info("End FibonacciService");
        return pass;
    }

    public static boolean test(final int input, final String expected) {
        final String actual = calculate(input);
        final boolean pass = expected.equals(actual);
        final String logMessage = (pass ? "PASS" : "FAIL") + " Numbers to generate: " + input + " expect '" + expected + "' = '" + actual + "'";
        if (pass) log.info(logMessage); else log.error(logMessage);
        return pass;
    }

    private static String calculate(int numbers) {
        if (numbers < 0) return "";
        if (numbers == 1) return "0";

        StringBuilder sb = new StringBuilder(numbers * 3);
        sb.append("0 1");
        int i = 0;
        int j = 1;
        for(int n = 2; n < numbers; ++n) {
            final int k = i + j;
            sb.append(' ').append(k);
            i = j;
            j = k;
        }

        return sb.toString();
    }

    static final TestDataList<Integer, String> testDataList = new TestDataList<>();
    static {
        final var list = testDataList.getList();
        list.add(new TestData<>(1, "0"));
        list.add(new TestData<>(2, "0 1"));
        list.add(new TestData<>(3, "0 1 1"));
        list.add(new TestData<>(4, "0 1 1 2"));
        list.add(new TestData<>(5, "0 1 1 2 3"));
        list.add(new TestData<>(6, "0 1 1 2 3 5"));
        list.add(new TestData<>(7, "0 1 1 2 3 5 8"));
    }
}