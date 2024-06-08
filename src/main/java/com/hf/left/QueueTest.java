package com.hf.left;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/6/8 22:40
 * @version: 1.0
 */
public class QueueTest {

    class MovingAverage{

        private Queue<Integer> queue;

        private int capacity;

        private int sum;

        public MovingAverage(int size){
            queue = new LinkedList<>();
            capacity = size;
        }

        public double next(int val){
            queue.offer(val);
            sum += val;
            if (queue.size() > capacity){
                sum -= queue.poll();
            }
            return (double) sum/queue.size();
        }
    }

    class RecentAverage{

        private Queue<Integer> times;

        private int windowSize;

        RecentAverage(){
            times = new LinkedList<>();
            windowSize = 3000;
        }

        public int ping(int t){
            times.offer(t);
            while (times.peek() + windowSize < t){
                times.poll();
            }
            return times.size();
        }
    }
}
