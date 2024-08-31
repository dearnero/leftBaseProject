package com.hf.left.operation.function;

import java.util.function.Consumer;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/8/27 16:12
 * @version: 1.0
 */
public class FunctionInterface {

    public static void main(String[] args) {
        // 消费式接口
        Consumer<Integer> consumer = new Consumer<>() {
            @Override
            public void accept(Integer o) {
                System.out.println(o);
            }
        };
        consumer.accept(11);
    }
}
