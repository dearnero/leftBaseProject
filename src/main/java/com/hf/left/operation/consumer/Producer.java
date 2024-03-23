package com.hf.left.operation.consumer;

public class Producer implements Runnable {

    private MyBlockingQueue<String> queue;

    public Producer(MyBlockingQueue<String> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        int num = 0;
        while (true){
            try {
                String task = String.valueOf(num);
                queue.put(task);
                System.out.println("producer:" + task);
                num++;
                Thread.sleep( (int)(Math.random() * 100));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
