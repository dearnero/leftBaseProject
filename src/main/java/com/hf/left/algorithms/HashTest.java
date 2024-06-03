package com.hf.left.algorithms;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/6/3 09:19
 * @version: 1.0
 */
public class HashTest {

    public boolean isAnagram(String s, String t){
        if (s.length() != t.length()){
            return false;
        }
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        for (int j = 0; j < t.length(); j++) {
            counts[t.charAt(j) - 'a']--;
            if (counts[t.charAt(j) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
