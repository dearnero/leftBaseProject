package com.hf.left.interview;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/6 12:09
 * @version: 1.0
 */
public class I02RemoveElement {

    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = 0;
        while (right < nums.length){
            if (nums[right] != val){
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }

    public static void main(String[] args) {
        new I02RemoveElement().removeElement(new int[]{3,2,2,3}, 3);
    }
}
