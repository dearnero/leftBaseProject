package com.hf.left.operation.consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/5/27 15:11
 * @version: 1.0
 */
public class MainExample {

    public static void main(String[] args) {

        BlockingQueue<Integer> myQueue = new ArrayBlockingQueue<>(16);
        new Thread(new Producer(myQueue)).start();
        new Thread(new Consumer(myQueue)).start();
    }

    static class Producer implements Runnable{

        private BlockingQueue<Integer> queue;

        Producer(BlockingQueue<Integer> queue){
            this.queue = queue;
        }

        @Override
        public void run() {
            int value = 0;
            while (true){
                try {
                    System.out.println("queue.put value:"+ value);
                    queue.put(value);
                    value++;
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class Consumer implements Runnable{

        private BlockingQueue<Integer> queue;

        Consumer(BlockingQueue<Integer> queue){
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true){
                try {
                    System.out.println("queue.take value:" + queue.take());
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
