package com.hf.left.hot;

import java.util.Stack;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/9/22 20:53
 * @version: 1.0
 */
public class HMinStack {

    private Stack<Integer> stack;

    private Stack<Integer> minStack;

    public HMinStack(){
        stack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    // 初始化堆栈对象
    public void push(int val){
        stack.push(val);
        minStack.push(Math.min(stack.peek(), minStack.peek()));
    }

    // 栈顶出栈
    public void pop(){
        stack.pop();
        minStack.pop();
    }

    // 获取堆栈顶部的元素
    public int top(){
        return stack.peek();
    }

    // 获取最小值
    public int getMin(){
        if (stack.isEmpty()){
            return stack.peek();
        }
        return minStack.peek();
    }
}
