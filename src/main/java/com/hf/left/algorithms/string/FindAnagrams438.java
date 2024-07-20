package com.hf.left.algorithms.string;

import java.util.*;

/**
 * @description:
 *      @link <a href="https://leetcode.cn/problems/VabMRr/description/">VabMRr</a>
 * @author: huang fu
 * @date: 2024/7/20 11:39
 * @version: 1.0
 */
public class FindAnagrams438 {
    public List<Integer> findAnagrams(String s, String p){
        int pLength = p.length();
        List<Integer> ans = new ArrayList<>();
        if (p.length() > s.length()) return ans;
        char[] sArr = new char[26];
        char[] pArr = new char[26];
        for (int i = 0; i < p.length(); i++) {
            sArr[s.charAt(i) - 'a']++;
            pArr[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sArr, pArr)) ans.add(0);
        for (int j = 1; j <= s.length() - pLength; j++) {
            sArr[s.charAt(j - 1) - 'a']--;
            sArr[s.charAt(j - 1 + pLength) - 'a']++;
            if (Arrays.equals(sArr, pArr)) {
                ans.add(j);
            }
        }
        return ans;
    }

    // cbaebabacd
    // cba bae aeb eba bab aba bac acd
    public static void main(String[] args) {
        new FindAnagrams438().findAnagrams("cbaebabacd", "abc");
    }
}
