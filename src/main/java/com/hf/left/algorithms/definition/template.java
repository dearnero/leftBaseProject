package com.hf.left.algorithms.definition;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/7 09:05
 * @version: 1.0
 */
public class template {

    public static void main(String[] args) {
        int[] nums = new int[10];
        int target = 10;
        int left = 0;
        int rigth = nums.length - 1;
        while (left <= rigth){
            int mid = (left + rigth) /2;
            if (nums[mid] == target){
                return;
            } else if (nums[mid] > target){
                rigth = mid + 1;
            } else {
                left = mid + 1;
            }
        }
    }
}
