package com.hf.left.interview;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/6 12:09
 * @version: 1.0
 */
public class RemoveElement02 {

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] != val){
                    nums[i] = nums[j];
                    nums[j] = val;
                    break;
                }
            }
        }
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                size++;
            }
        }
        return size;
    }

    public int removeElement2(int[] nums, int val){
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val){
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        new RemoveElement02().removeElement(new int[]{3,2,2,3}, 3);
    }
}
