package com.hf.left.hot;

/**
 * @description: 287. 寻找重复数
 * 1. 很有技巧的一道题目，最重要的是要读懂题目的规则
 * 2. 使用二分查找的方式，每次找到中位数，和统计值对比
 *  2.1 当统计值 > 中位数，说明重复值在左段
 *  2.2 当统计值 <= 中位数，说明重复值在右段
 * <a href = "https://leetcode.cn/problems/find-the-duplicate-number/?envType=study-plan-v2&envId=top-100-liked"></a>
 * @author: huang fu
 * @date: 2024/9/16 20:18
 * @version: 1.0
 */
public class HFindDuplicate {

    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 1, r = n - 1, ans = -1;
        while (l <= r){
            int mid =  (l + r) >> 1;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] <= mid){
                    cnt++;
                }
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
               r = mid - 1;
               ans = mid;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new HFindDuplicate().findDuplicate(new int[]{1,1,2,3,4});
    }
}
