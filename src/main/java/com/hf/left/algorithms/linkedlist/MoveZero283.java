package com.hf.left.algorithms.linkedlist;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/6/18 08:49
 * @version: 1.0
 */
public class MoveZero283 {

    public void moveZeros(int[] nums){
        int left = 0;
        int right = 0;
        while (right < nums.length){
            if (nums[right] != 0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }

    public void moveZeros2(int[] nums){
        // 记录非0位置
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[j] = nums[i];
                if (i != j){
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

}
