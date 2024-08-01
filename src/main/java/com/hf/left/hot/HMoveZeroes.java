package com.hf.left.hot;

/**
 * @description: 283. 移动零
 * 算法：双指针
 * 1. 快慢指针，慢指针指向待交换位置，快指针一直往下，直到数组完结
 * @link <a href="https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked"></a>
 * @author: huang fu
 * @date: 2024/8/1 11:54
 * @version: 1.0
 */
public class HMoveZeroes {
    // [0,1,0,3,12]
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length){
            if (nums[right] != 0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right]= temp;
                left++;
            }
            right++;
        }
    }
}
