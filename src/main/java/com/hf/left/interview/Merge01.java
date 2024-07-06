package com.hf.left.interview;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/6 11:37
 * @version: 1.0
 */
public class Merge01 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n - 1;
        int km = m - 1;
        int kn = n - 1;
        for (int i = length; i >= 0; i--) {
            if (kn < 0 || (km >= 0 && nums1[km] >= nums2[kn])){
                nums1[i] = nums1[km];
                --km;
            }else {
                nums1[i] = nums2[kn];
                --kn;
            }
        }
    }
}
