package com.hf.left.hot;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/9/25 10:27
 * @version: 1.0
 */
public class HFindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int lf = 0, rt = 0;
        while (lf < nums1.length && rt < nums2.length){
            if (nums1[lf] > nums2[rt]){
                res[lf + rt] = nums2[rt++];
            } else {
                res[lf + rt] = nums1[lf++];
            }
        }
        while (lf < nums1.length){
            res[lf + rt] = nums1[lf++];
        }
        while (rt < nums2.length){
            res[lf + rt] = nums2[rt++];
        }
        int mid = (res.length - 1) / 2;
        if (res.length % 2 == 0){
            return (double) (res[mid] + res[mid + 1]) / 2;
        }
        return res[mid];
    }

    public static void main(String[] args) {
        new HFindMedianSortedArrays().findMedianSortedArrays(new int[]{1,2}, new int[]{3,4});
    }
}
