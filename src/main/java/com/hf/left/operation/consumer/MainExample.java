package com.hf.left.operation.consumer;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/5/27 15:11
 * @version: 1.0
 */
public class MainExample {

    public static void main(String[] args) {

        MyBlockingQueue<String> myQueue = new MyBlockingQueue<>(1);
        new Thread(new Producer(myQueue)).start();
//        new Thread(new Consumer(myQueue)).start();
    }
}
