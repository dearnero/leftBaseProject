package com.hf.left.hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @description: 56. 合并区间
 * @link <a href= "https://leetcode.cn/problems/merge-intervals/description/?envType=study-plan-v2&envId=top-100-liked"></a>
 * @author: huang fu
 * @date: 2024/8/11 10:55
 * @version: 1.0
 */
public class HMerge {
    // [[1,3],[2,6],[8,10],[15,18]]
    // [[1,10],[2,3],[4,5],[6,7],[8,9]]
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        int right = 0, n = intervals.length;
        while (right < n){
            int min = intervals[right][0];
            int max = intervals[right][1];
            while (++right < n && intervals[right][0] <= max){
                max = Math.max(max, intervals[right][1]);
            }
            ans.add(new int[]{min, max});
        }
        return ans.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        new HMerge().merge(new int[][]{
                {2,3},{4,5},{6,7},{8,9},{1,10}});
    }
}
