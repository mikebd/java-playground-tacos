package com.mikebd.playground.scratch1.util.test;

import lombok.Getter;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class TestDataList<Input, Expected> {
    public boolean test(BiFunction<Input, Expected, Boolean> func, final Logger log) {
        boolean pass = true;
        for (final var testData : list) {
            pass &= testData.test(func);
        }
        if (pass) log.info("Overall: PASS"); else log.error("Overall: FAIL");
        return pass;
    }

    @Getter
    private final List<TestData<Input, Expected>> list = new ArrayList<>();
}
