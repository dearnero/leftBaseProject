package com.hf.left.interview;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/25 15:57
 * @version: 1.0
 */
public class ILongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<>();
        for (int num : nums) {
            num_set.add(num);
        }
        int longestStreak = 0;
        for (int num : num_set) {
            if (!num_set.contains(num - 1)){
                int currentNum = num;
                int currentStreak = 1;
                while (num_set.contains(currentNum + 1)){
                    currentNum+= 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
