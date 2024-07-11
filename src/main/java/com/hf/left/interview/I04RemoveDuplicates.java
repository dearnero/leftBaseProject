package com.hf.left.interview;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/11 19:57
 * @version: 1.0
 */
public class I04RemoveDuplicates {

    public int removeDuplicates(int[] nums) {

        int left = 2;
        int right = 2;
        while (right < nums.length){
            if (nums[left - 2] != nums[right]){
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }
}
