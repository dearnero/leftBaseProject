package com.hf.left.hot;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/8/11 12:34
 * @version: 1.0
 */
public class HMaxProduct {
    public int maxProduct(int[] nums) {
        double ans = nums[0], min = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            double maxTemp = max;
            max = Math.max(nums[i] * max, Math.max(nums[i], nums[i] * min));
            min = Math.min(nums[i] * min, Math.min(nums[i], nums[i] * maxTemp));
            ans = Math.max(ans, max);
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        new HMaxProduct().maxProduct(new int[]{1,-3, 2,0,3,4,5,2});

    }
}
