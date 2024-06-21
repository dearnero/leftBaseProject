package com.hf.left.base;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/6/20 10:19
 * @version: 1.0
 */
public class LambdaTest {

    public static void main(String[] args) {
        int num = 10;
        Function<Integer, Integer> addNum = (value) -> value + num;
        int result = addNum.apply(5);
        System.out.println(result);
        // - 有闭包
        Supplier<Integer> counter = createCounter();
        System.out.println(counter.get());
        System.out.println(counter.get());
        System.out.println(counter.get());
    }

    private static Supplier<Integer> createCounter() {
        final int[] count = {0};
        return () -> ++count[0];
    }
}
