package com.hf.left.hot;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 3. 无重复字符的最长子串
 * @link <a href = "https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-100-liked"></a>
 * @author: huang fu
 * @date: 2024/8/10 09:28
 * @version: 1.0
 */
public class HLengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, ans = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            while (set.contains(ch)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        new HLengthOfLongestSubstring().lengthOfLongestSubstring("abc");
    }
}
