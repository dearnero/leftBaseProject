package com.hf.left.operation.consumer;

public class Consumer implements Runnable{

    private MyBlockingQueue<String> queue;

    public Consumer(MyBlockingQueue<String> queue){
        this.queue = queue;
    }

    @Override
    public void run() {

        while (true){

            try {
                System.out.println("consumer:" + queue.take());
                Thread.sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
