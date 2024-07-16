package com.hf.left.interview;

import java.util.Stack;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/16 10:00
 * @version: 1.0
 */
public class IMinStack {

    private Stack<Integer> stack;

    private Stack<Integer> minStack;

    public IMinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min(stack.peek(), minStack.peek()));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if (stack.isEmpty()){
            return stack.peek();
        }
        return minStack.peek();
    }
}
