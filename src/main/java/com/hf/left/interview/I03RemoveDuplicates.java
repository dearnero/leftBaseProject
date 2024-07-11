package com.hf.left.interview;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/11 19:40
 * @version: 1.0
 */
public class I03RemoveDuplicates {

    public int removeDuplicates(int[] nums) {

        int left = 1;
        int right = 1;
        while (right < nums.length){
            if (nums[right] != nums[right - 1]){
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }
}
