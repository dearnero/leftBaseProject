package com.hf.left.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/26 20:31
 * @version: 1.0
 */
public class IMinWindow {

    private Map<Character, Integer> winMap = new HashMap<>();

    private Map<Character, Integer> tMap = new HashMap<>();

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int begin = 0, end = 0, minlength = Integer.MAX_VALUE;
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int lf = 0, rt = -1;
        int n =  s.length();
        while (rt < n){
            ++rt;
            if(rt < n && tMap.containsKey(s.charAt(rt))){
                winMap.put(s.charAt(rt), winMap.getOrDefault(s.charAt(rt), 0) + 1);
            }
            while (lf <= rt && check()){
                if (rt - lf + 1 < minlength){
                    minlength = rt - lf + 1;
                    begin = lf;
                    end = lf + minlength;
                }
                char lc = s.charAt(lf);
                if (tMap.containsKey(lc)){
                    winMap.put(lc, winMap.getOrDefault(lc, 0) - 1);
                }
                lf++;
            }
        }
        return minlength == Integer.MAX_VALUE ? "" : s.substring(begin, end);
    }

    private boolean check(){
        for (Character key : tMap.keySet()) {
            if (winMap.get(key) == null || winMap.get(key) < tMap.get(key)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new IMinWindow().minWindow("a", "a");
    }


}
