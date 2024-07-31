package com.hf.left.hot;

import java.util.Arrays;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/31 10:28
 * @version: 1.0
 */
public class HRob {

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int f0 = nums[0], f1 = Math.max(nums[1], nums[0]);
        for (int i = 2; i < nums.length; i++) {
            int temp = Math.max(f1, f0 + nums[i]);
            f0 = f1;
            f1 = temp;
        }
        return f1;
    }

    public int rob2(int[] nums){
        if (nums.length == 1) return nums[0];
        int[] ans = new int[nums.length];
        ans[0] = nums[0]; ans[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < nums.length; i++) {
            ans[i] = Math.max(ans[i - 1], ans[i - 2] + nums[i]);
        }
        return ans[nums.length - 1];
    }

    public static void main(String[] args) {
        new HRob().rob2(new int[]{1,2,3,1});
    }


    public int rob1(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return helper1(nums.length - 1, nums, memo);
    }

    private int helper1(int n, int[] nums, int[] memo){
        if (n < 0 ) return 0;
        if (memo[n] > -1){
            return memo[n];
        }
        return memo[n] = Math.max(helper1(n - 1, nums, memo), helper1(n - 2, nums, memo) + nums[n]);
    }
}
