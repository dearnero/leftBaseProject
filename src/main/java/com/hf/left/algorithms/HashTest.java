package com.hf.left.algorithms;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/6/3 09:19
 * @version: 1.0
 */
public class HashTest {

    /**
     * 是否是异位词
     * @return
     */
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

    /**
     * 外星语言是否排序
     * @return
     */
    public boolean isAlienSorted(String[] words, String order){

        int[] dict = new int[26];
        for (int i = 0; i < order.length(); i++) {
            dict[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            if (!isSort(words[i], words[i - 1], dict)){
                return false;
            }
        }
        return true;
    }

    private boolean isSort(String t1, String t2, int[] dirt){
        int minLength = Math.min(t1.length(), t2.length());
        for (int i = 0; i < minLength; i++) {
            if (t1.charAt(i) == t2.charAt(i)){
                continue;
            }
            return dirt[t1.charAt(i) - 'a'] > dirt[t2.charAt(i) - 'a'];
        }
        return t1.length() >= t2.length();
    }

    public static void main(String[] args) {
        String[] words = {"ubg","kwh"};
        new HashTest().isAlienSorted(words, "qcipyamwvdjtesbghlorufnkzx");
    }
}
