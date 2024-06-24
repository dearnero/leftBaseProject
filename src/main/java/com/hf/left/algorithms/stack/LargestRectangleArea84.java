package com.hf.left.algorithms.stack;

import java.util.Stack;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/6/23 15:06
 * @version: 1.0
 */
public class LargestRectangleArea84 {

    public int largestRectangleArea(int[] heights){
        int max_area = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            int nowHeight = heights[i];
            while (stack.peek() != -1 && nowHeight < heights[stack.peek()]){
                int popIndex = stack.pop();
                max_area = Math.max(max_area, heights[popIndex] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1){
            int popIndex = stack.pop();
            max_area = Math.max(max_area, heights[popIndex] * (heights.length - stack.peek() - 1));
        }
        return max_area;
    }

    public static void main(String[] args) {
        System.out.println(new LargestRectangleArea84().largestRectangleArea(new int[]{2,3}));
    }
}
