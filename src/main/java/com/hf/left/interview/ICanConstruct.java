package com.hf.left.interview;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/24 20:51
 * @version: 1.0
 */
public class ICanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ans = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            ans[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int val = --ans[ransomNote.charAt(i) - 'a'];
            if (val < 0){
                return false;
            }
        }
        return true;
    }
}
