package com.hf.left.interview;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/13 20:33
 * @version: 1.0
 */
public class I09Jump {
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end){
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
