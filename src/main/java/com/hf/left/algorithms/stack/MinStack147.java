package com.hf.left.algorithms.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/6/23 14:51
 * @version: 1.0
 */
public class MinStack147 {

    class MinStack{

        Deque<Integer> xStack;

        Deque<Integer> minStack;

        MinStack(){
            xStack = new LinkedList<>();
            minStack = new LinkedList<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int x){
            xStack.push(x);
            minStack.push(Math.min(minStack.peek(),x));
        }

        public void pop(){
            xStack.pop();
            xStack.pop();
        }

        public int top(){
            return xStack.peek();
        }

        public int min(){
            return minStack.peek();
        }
    }
}
