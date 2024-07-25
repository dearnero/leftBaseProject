package com.hf.left.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/25 10:16
 * @version: 1.0
 */
public class IMerge {
    public int[][] merge(int[][] intervals) {
        // [[1,3],[2,6],[8,10],[15,18]]
        // [[1,10],[2,3],[4,5],[6,7],[8,9]]
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        int i = 0;
        while (i < n){
            i++;
            int max = intervals[i - 1][1];
            int min = intervals[i - 1][0];
            while (i < n && intervals[i][0] <= max){
                max = Math.max(max, intervals[i][1]);
                i++;
            }
            ans.add(new int[]{min, max});
        }
        return ans.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        new IMerge().merge(intervals);
    }
}
