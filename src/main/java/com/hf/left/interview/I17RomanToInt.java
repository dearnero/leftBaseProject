package com.hf.left.interview;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/15 20:42
 * @version: 1.0
 */
public class I17RomanToInt {
    public int romanToInt(String s) {
        if (s.length() == 0){
            return 0;
        }
        if (s.length() == 1){
            return getValue(s.charAt(0));
        }
        int ans = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int val = getValue(s.charAt(i));
            int nextVal = getValue(s.charAt(i + 1));
            if (val >= nextVal){
                ans += val;
            } else {
                ans -= val;
            }
        }
        ans += getValue(s.charAt(s.length() - 1));
        return ans;
    }

    private int getValue(char ch){
        switch (ch){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
