package com.hf.left.hot;

/**
 * @description: 215. 数组中的第K个最大元素
 * @link <a href="https://leetcode.cn/problems/kth-largest-element-in-an-array/?envType=study-plan-v2&envId=top-100-liked"></a>
 * 1. 受限于题目给的O(n)的时间复杂度要求，此处使用桶排序的思路
 * 2. 桶排序适用于：适用于数据范围相对较小且分布均匀的情况
 * @author: huang fu
 * @date: 2024/9/3 15:03
 * @version: 1.0
 */
public class HFindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        int[] bucket = new int[20001];
        for (int num : nums) {
            bucket[num + 10000]++;
        }
        for (int i = 20000; i >= 0; i--) {
             k = k - bucket[i];
             if (k <= 0){
                 return i - 10000;
             }
        }
        return 0;
    }
}
