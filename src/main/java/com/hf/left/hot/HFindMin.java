package com.hf.left.hot;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/9/26 15:29
 * @version: 1.0
 */
public class HFindMin {

    public int findMin(int[] nums) {

        int left = 0, right = nums.length -1;
        while (left < right){
            int mid = left + (right - left)/2;
            if (nums[mid] < nums[nums.length -1]){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        new HFindMin().findMin(new int[]{11,13,15,17});
    }

}
