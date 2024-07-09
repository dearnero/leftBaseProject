package com.hf.left.algorithms;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/9 14:23
 * @version: 1.0
 */
public class MaxProduct152 {

    public int maxProduct(int[] nums) {

        double ans = nums[0], minF = nums[0], maxF = nums[0];
        for (int i = 1; i < nums.length; i++) {
            double mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(maxF, ans);
        }
        return (int)ans;
    }
}
