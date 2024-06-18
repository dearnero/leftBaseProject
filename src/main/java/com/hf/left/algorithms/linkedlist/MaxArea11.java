package com.hf.left.algorithms.linkedlist;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/6/18 09:13
 * @version: 1.0
 */
public class MaxArea11 {

    public int maxArea(int[] height) {

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int minHeight = Math.min(height[i], height[j]);
                max = Math.max(max, minHeight * (j - i));
            }

        }
        return max;
    }

    public int maxArea2(int[] height){
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right){
            int minHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, (right - left) * minHeight);
            if (height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        new MaxArea11().maxArea2(height);
    }
}
