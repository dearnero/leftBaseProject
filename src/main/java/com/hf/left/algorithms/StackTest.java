package com.hf.left.algorithms;

import java.util.Stack;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/6/3 19:32
 * @version: 1.0
 */
public class StackTest {

    // 后缀表达式
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token){
                case "+":
                case "-":
                case "*":
                case "/":
                    int l2 = stack.pop();
                    int l1 = stack.pop();
                    stack.push(calculate(l1, l2 , token));
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private int calculate(int l1, int l2, String operator){
        switch (operator){
            case "+":
                return l1 + l2;
            case "-":
                return l1 - l2;
            case "*":
                return l1 * l2;
            case "/":
                return l1 / l2;
            default:
                return 0;
        }
    }

    public int[] asteroidCollision(int[] asteroids){
        Stack<Integer> stack = new Stack<>();
        boolean destroyed = false;
        for (int as : asteroids) {
            while (!stack.empty() && as < 0 && stack.peek() > 0){
                if (stack.peek() < -as){
                    stack.pop();
                    continue;
                }else if (stack.peek() == -as){
                    stack.pop();
                }
                // 此处考虑到了新元素被撞击的情况
                destroyed = true;
                break;
            }
            if (!destroyed){
                stack.push(as);
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }

}
