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

    // 滑动窗口
    public List<Integer> findAnagrams(String s, String p){
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length()) return ans;
        int[] sArr = new int[26];
        int[] pArr = new int[26];
        for (int i = 0; i < p.length(); i++) {
            sArr[s.charAt(i) - 'a']++;
            pArr[p.charAt(i) - 'a']++;
        }
        if(Arrays.equals(sArr, pArr)) ans.add(0);
        for (int i = 1; i < s.length() - p.length() + 1; i++) {
            sArr[s.charAt(i - 1) - 'a'] --;
            sArr[s.charAt(i - 1 + p.length()) -'a'] ++;
            if(Arrays.equals(sArr, pArr)) ans.add(i);
        }
        return ans;
    }
    // cba eb
    // cbaebabacd
    // cba bae aeb eba bab aba bac acd
    public static void main(String[] args) {
        new FindAnagrams438().findAnagrams("cbaebabacd", "abc");
    }
}
