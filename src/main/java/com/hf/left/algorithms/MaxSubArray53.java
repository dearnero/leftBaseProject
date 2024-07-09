package com.hf.left.algorithms;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/9 11:59
 * @version: 1.0
 */
public class MaxSubArray53 {

    public int maxSubArray(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        int maxArea = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans[i] = Math.max(ans[i - 1], 0) + nums[i];
            maxArea = Math.max(maxArea, ans[i]);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        new MaxSubArray53().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
}