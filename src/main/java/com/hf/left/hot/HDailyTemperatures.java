package com.hf.left.hot;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/9/23 23:08
 * @version: 1.0
 */
public class HDailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]){
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
