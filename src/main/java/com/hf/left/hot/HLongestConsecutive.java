package com.hf.left.hot;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 128. 最长连续序列
 * 算法：哈希
 * 1. 使用hashset保存所有数值
 * 2. 开启第二次循环
 * 3. 如果当前值 减 1在set内，那么说明自己不是首位，跳过
 * 4. 如果当前值 减 1不在set内，那么说明自己是首位，开始循环自己的下一个是否在数组内，
 * 并且统计下一个是否在数组内，按此下推
 * @link <a href = "https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-100-liked"></a>
 * @author: huang fu
 * @date: 2024/8/3 09:19
 * @version: 1.0
 */
public class HLongestConsecutive {

    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longestStreak = 0;
        for (int num : nums) {
            if (!numSet.contains(num - 1)){
                int curNum = num;
                int curStreak = 1;
                while (numSet.contains(curNum + 1)){
                    curStreak++;
                    curNum++;
                }
                longestStreak = Math.max(curStreak, longestStreak);
            }
        }
        return longestStreak;
    }
}
