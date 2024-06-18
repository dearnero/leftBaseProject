package com.hf.left.algorithms.linkedlist;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/6/18 08:49
 * @version: 1.0
 */
public class MoveZero283 {

    public void moveZeros(int[] nums){
        int n = nums.length;
        int l = 0, r = 0;
        while (r < n){
            if (nums[r] != 0){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
            }
            r++;
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
