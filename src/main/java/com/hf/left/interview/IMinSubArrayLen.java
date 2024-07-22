package com.hf.left.interview;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/22 21:36
 * @version: 1.0
 */
public class IMinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int start = 0, end = 0, sum = 0, ans = Integer.MAX_VALUE;
        while (end < n){
            sum += nums[end];
            while (sum >= target){
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        System.out.println(new IMinSubArrayLen().minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}
