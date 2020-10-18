package com.mikebd.playground.scratch1.service;

import com.mikebd.playground.scratch1.util.test.TestData;
import com.mikebd.playground.scratch1.util.test.TestDataList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * See: https://algorithms.tutorialhorizon.com/convert-roman-number-to-integer/
 *
 * I = 1
 * V = 5
 * X = 10
 * L = 50
 * C = 100
 * D = 500
 * M = 1000
 *
 * Roman numerals are usually written in highest to lowest from left to right except for some
 * special cases where left character is less than the right character. for example ‘IV’ is
 * equivalent to 4 not ‘IIII’. In such cases, subtract the left character value from the right
 * character value. ‘IV’ will be 5-1 = 4, same for ‘IX’ = 10-1 = 9. Below are the cases:
 *    I can be placed before V or X, represents subtract one, so IV (5-1) = 4 and 9 is IX (10-1)=9.
 *    X can be placed before L or C represents subtract ten, so XL (50-10) = 40 and XC (100-10)=90.
 *    C placed before D or M represents subtract hundred, so CD (500-100)=400 and CM (1000-100)=900.
 */
@Service
@Slf4j
public class RomanNumberService {
    public boolean run() {
        log.info("Start RomanNumberService");
        final boolean pass = testDataList.test(RomanNumberService::test, log);
        log.info("End RomanNumberService");
        return pass;
    }

    public static boolean test(final String input, final int expected) {
        final int actual = calculate(input);
        final boolean pass = expected == actual;
        final String logMessage = (pass ? "PASS " : "FAIL ") + input + " expect " + expected + " = " + actual;
        if (pass) log.info(logMessage); else log.error(logMessage);
        return pass;
    }

    private static int calculate(final String input) {
        if (null == input || input.length() == 0) return 0;
        int value = 0;
        for (int i = 0; i < input.length(); ++i) {
            final int currentDigitValue = digitValue(input.charAt(i));
            boolean validDoubleDigitValue = false;
            if ((currentDigitValue == 1 || currentDigitValue == 10 || currentDigitValue == 100) && ((i + 1) < input.length())) {
                final int nextDigitValue = digitValue(input.charAt(i + 1));
                final int doubleDigitValue = nextDigitValue - currentDigitValue;
                // log.info("double digit value = {}", doubleDigitValue);
                if (doubleDigitValue == 4 || doubleDigitValue == 9 ||
                        doubleDigitValue == 40 || doubleDigitValue == 90 ||
                        doubleDigitValue == 400 || doubleDigitValue == 900) {
                    value += doubleDigitValue;
                    validDoubleDigitValue = true;
                    ++i;
                }
            }
            if (!validDoubleDigitValue) {
                value += currentDigitValue;
            }
        }
        return value;
    }

    private static int digitValue(final char input) {
        final int index = Character.toUpperCase(input) - 'A';
        return (index >= 0 && index < ROMAN_DIGITS.length) ?
            ROMAN_DIGITS[index] : 0;
    }

    static final TestDataList<String, Integer> testDataList = new TestDataList<>();
    static {
        final var list = testDataList.getList();
        list.add(new TestData<>("", 0));
        list.add(new TestData<>("A", 0));
        list.add(new TestData<>("I", 1));
        list.add(new TestData<>("i", 1));
        list.add(new TestData<>("III", 3));
        list.add(new TestData<>("IV", 4));
        list.add(new TestData<>("V", 5));
        list.add(new TestData<>("VI", 6));
        list.add(new TestData<>("IX", 9));
        list.add(new TestData<>("X", 10));
        list.add(new TestData<>("XII", 12));
        list.add(new TestData<>("IXX", 19));
        list.add(new TestData<>("XL", 40));
        list.add(new TestData<>("XLI", 41));
        list.add(new TestData<>("L", 50));
        list.add(new TestData<>("XC", 90));
        list.add(new TestData<>("XCI", 91));
        list.add(new TestData<>("C", 100));
        list.add(new TestData<>("CD", 400));
        list.add(new TestData<>("CDI", 401));
        list.add(new TestData<>("D", 500));
        list.add(new TestData<>("DXLII", 542));
        list.add(new TestData<>("CM", 900));
        list.add(new TestData<>("CMI", 901));
        list.add(new TestData<>("M", 1000));
        list.add(new TestData<>("MXIV", 1014));
        list.add(new TestData<>("MIXX", 1019));
        list.add(new TestData<>("MXXIII", 1023));
    }

    private static final int ROMAN_DIGITS[] = new int[] {
            0,      // A
            0,      // B
            100,    // C
            500,    // D
            0,      // E
            0,      // F
            0,      // G
            0,      // H
            1,      // I
            0,      // J
            0,      // K
            50,      // L
            1000,   // M
            0,      // N
            0,      // O
            0,      // P
            0,      // Q
            0,      // R
            0,      // S
            0,      // T
            0,      // U
            5,      // V
            0,      // W
            10,     // X
            0,      // Y
            0       // Z
    };
}