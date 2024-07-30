package com.hf.left.hot;

/**
 * @description: 41. 缺失的第一个正数
 * 首先这个题目处理起来很绕，也很有技巧，类似于把原数组当成了map中的数组使用，使用映射的方式
 * 1. 处理数组中的负数，将其置为n+1; 因为后面的映射仅处理 <n 的
 * 2. 循环数组，将数组中所有小于n的值，映射到数组索引中，并将该索引对应的值改为-绝对值
 * 3. 再次循环数组，找到数组中首个大于0的正数，其索引+1，就是缺失的第一个正数
 * @link <a href = "https://leetcode.cn/problems/first-missing-positive/?envType=study-plan-v2&envId=top-100-liked"></a>
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
