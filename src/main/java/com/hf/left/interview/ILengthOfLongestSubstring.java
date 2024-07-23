package com.hf.left.interview;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/22 22:08
 * @version: 1.0
 */
public class ILengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int left = 0, right = -1, ans = 0;
        while (left < s.length()){
            if (left != 0){
                set.remove(s.charAt(left - 1));
            }
            while (right + 1 < s.length() && !set.contains(s.charAt(right + 1))){
                set.add(s.charAt(right + 1));
                right++;
            }
            ans = Math.max(ans, right - left + 1);
            left++;
        }
        return ans;
    }

    public static void main(String[] args) {
        new ILengthOfLongestSubstring().lengthOfLongestSubstring(" ");
    }
}
