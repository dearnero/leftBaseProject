package com.hf.left.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/23 10:04
 * @version: 1.0
 */
public class IIsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);
            if ((s2t.containsKey(s1) && s2t.get(s1) != t1) || (t2s.containsKey(t1) && t2s.get(t1) != s1)){
                return false;
            }
            s2t.put(s1, t1);
            t2s.put(t1, s1);
        }
        return true;
    }

    public static void main(String[] args) {
        new IIsIsomorphic().isIsomorphic("foo", "bar");
    }
}
