package com.hf.left.explorations;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/8/21 18:22
 * @version: 1.0
 */
public class Java21v {

    public static void main(String[] args) {

        // 创建一个虚拟线程
        Thread vThread = Thread.ofVirtual().start(() -> {
            try {
                System.out.println("虚拟线程开始运行: " + Thread.currentThread());
                Thread.sleep(1000); // 模拟一些工作
                System.out.println("虚拟线程完成: " + Thread.currentThread());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        });
        System.out.println("主线程开始: " + Thread.currentThread());
        // 主线程等待虚拟线程完成
        try {
            vThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程完成: " + Thread.currentThread());
    }
}
