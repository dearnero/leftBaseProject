package com.hf.left.interview;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/6 11:37
 * @version: 1.0
 */
public class I01Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1;
        int right = n - 1;
        for (int i = nums1.length - 1; i >=0; --i) {
            if (right < 0 || (left >=0 && nums1[left] > nums2[right])) {
                nums1[i] = nums1[left];
                --left;
            } else {
                nums1[i] = nums2[right];
                --right;
            }
        }
    }
}
