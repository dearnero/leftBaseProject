package com.hf.left.hot;

/**
 * @description: 238. 除自身以外数组的乘积
 * 1. 很有技巧的一道题目，要求要按照O(n)的复杂度进行解答
 * 2. 分别初始化左数组、右数组，保存从左往右，和从右往左的乘数积
 * 3. 最后再将左数组和右数组的对应值相乘
 * @link <a href = "https://leetcode.cn/problems/product-of-array-except-self/?envType=study-plan-v2&envId=top-100-liked"></a>
 * @author: huang fu
 * @date: 2024/8/30 15:33
 * @version: 1.0
 */
public class HProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i -1] * nums[i - 1];
        }
        int[] right = new int[n];
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        int[] ans = new int[n];
        for (int i = 0; i < left.length; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }
}
