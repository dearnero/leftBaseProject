package com.hf.left.operation.thread;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/8/27 10:09
 * @version: 1.0
 */
public class BaseThread {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(111);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
            }
        }).start();

        Thread t2 = new Thread(() -> {
            // 用于让出当前线程的资源，让操作系统再调度一次
            Thread.yield();
            System.out.println(222);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        });
        t2.start();
        try {
            // 等待t2执行完成后，继续
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(333);
    }

}
