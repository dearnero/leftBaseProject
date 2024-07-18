package com.hf.left.algorithms.string;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/18 22:09
 * @version: 1.0
 */
public class FirstUniqChar387 {

    public int firstUniqChar(String s) {

        int[] temp = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            temp[s.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < n; i++) {
            if (temp[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
