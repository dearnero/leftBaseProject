package com.hf.left.operation.consumer;

public class Deep {

    public static void main(String[] args) {
        MyBlockingQueue<String> queue = new MyBlockingQueue<String>(10);
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }
}
