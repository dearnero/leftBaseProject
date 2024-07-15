package com.hf.left.interview;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/15 15:16
 * @version: 1.0
 */
public class I13ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] lefts = new int[n];
        lefts[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            lefts[i] = lefts[i - 1] * nums[i - 1];
        }
        int[] rights = new int[n];
        rights[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            rights[i] = rights[i + 1] * nums[i + 1];
        }
        int[] ans = new int[n];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = lefts[i] * rights[i];
        }
        return ans;
    }
}
