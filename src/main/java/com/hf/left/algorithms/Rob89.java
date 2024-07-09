package com.hf.left.algorithms;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/9 16:27
 * @version: 1.0
 */
public class Rob89 {
    public int rob(int[] nums) {
        int[][] robStatus = new int[nums.length][2];
        robStatus[0][0] = 0;
        robStatus[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            robStatus[i][0] = Math.max(robStatus[i - 1][0], robStatus[i - 1][1]);
            robStatus[i][1] = robStatus[i - 1][0] + nums[i];
        }
        return Math.max(robStatus[nums.length - 1][0], robStatus[nums.length - 1][1]);
    }
}
