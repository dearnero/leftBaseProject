package com.hf.left.hot;

/**
 * @description: 189. 轮转数组
 * 1. k = k % nums.length 避免数组越界
 * 2. 要不数组反转的代码写好
 * 3. 通过三次反转实现
 * @link <a href ="https://leetcode.cn/problems/rotate-array/description/?envType=study-plan-v2&envId=top-100-liked"></a>
 * @author: huang fu
 * @date: 2024/8/26 18:33
 * @version: 1.0
 */
public class HRotate {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        invert(nums, 0, nums.length - 1);
        invert(nums, 0, k - 1);
        invert(nums, k, nums.length - 1);
    }

    private void invert(int[] nums, int start, int end) {
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
