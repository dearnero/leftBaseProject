package com.hf.left.hot;

import java.util.Arrays;

/**
 * @description: 最长递增子序列
 * 1. 采用动态递推
 * 2. 递推数组dp[i]: 以 nums[i] 结尾的最长递增子序列的长度
 * 3. 递归公式：对每个 i 遍历之前所有的数字，如果 nums[i] > nums[j]，则更新 dp[i]，即 dp[i] = max(dp[i], dp[j] + 1)
 * <a href = "https://leetcode.cn/problems/longest-increasing-subsequence/description/?envType=study-plan-v2&envId=top-100-liked"></>
 * @author: huang fu
 * @date: 2024/10/10 21:39
 * @version: 1.0
 */
public class HLengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, 1);
        int maxLIS = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    ans[i] = Math.max(ans[i], ans[j] + 1);
                }
            }
            maxLIS = Math.max(maxLIS, ans[i]);
        }
        return maxLIS;
    }
}
