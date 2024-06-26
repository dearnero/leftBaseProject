package com.hf.left.algorithms.map;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/6/26 19:15
 * @version: 1.0
 */
public class IsAnagramLCR032 {

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length() || s.equals(t)) return false;
        int[] arr  = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i) - 'a']--;
            if(arr[t.charAt(i) - 'a'] < 0){
                return false;

            }
        }
        return true;
    }
}
