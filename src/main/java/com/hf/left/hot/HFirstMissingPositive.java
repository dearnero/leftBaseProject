package com.hf.left.hot;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/29 17:11
 * @version: 1.0
 */
public class HFirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n){
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0){
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        new HFirstMissingPositive().firstMissingPositive(new int[]{3,4,-1,1});
    }
}
