package com.hf.left.algorithms;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/5/31 10:31
 * @version: 1.0
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {

        int n = nums.length, l = 0, r = 0;
        while (r < n){
            if (nums[r] != 0){
                swap(nums, l, r);
                l++;
            }
            r++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    // [0,1,0,3,12]
}
