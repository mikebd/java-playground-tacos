package com.mikebd.playground.scratch1.util.test;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.BiFunction;

@AllArgsConstructor
@Getter
public class TestData<Input, Expected> {
    public boolean test(BiFunction<Input, Expected, Boolean> func) {
        return func.apply(getInput(), getExpected());
    }

    private final Input input;
    private final Expected expected;
}
