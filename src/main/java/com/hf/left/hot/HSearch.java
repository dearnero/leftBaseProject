package com.hf.left.hot;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/9/26 14:29
 * @version: 1.0
 */
public class HSearch {
    // [0,1,2,4,5,6,7]
    // [4,5,6,7,0,1,2]
    public int search(int[] nums, int target) {
        int lf = 0, rt = nums.length - 1;
        while (lf <= rt){
            int mid = lf + (rt - lf) / 2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] >= nums[0]){
                if (target >= nums[0] && target < nums[mid]){
                    rt = mid - 1;
                } else {
                    lf = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[rt]){
                    lf = mid + 1;
                } else {
                    rt = mid - 1;
                }
            }
        }
        return -1;
    }
}
