package com.hf.left.hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/8/10 10:15
 * @version: 1.0
 */
public class HFindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] sArr = new int[26];
        int[] pArr = new int[26];
        for (int i = 0; i < p.length(); i++) {
            sArr[s.charAt(i) - 'a'] ++;
            pArr[p.charAt(i) - 'a'] ++;
        }
        if (Arrays.equals(sArr, pArr)) ans.add(0);
        for (int i = 1; i < s.length() - p.length() + 1; i++) {
            sArr[s.charAt(i - 1) - 'a'] --;
            sArr[s.charAt(i - 1 + p.length()) - 'a'] ++;
            if (Arrays.equals(sArr, pArr)) ans.add(i);
        }
        return ans;
    }
}
