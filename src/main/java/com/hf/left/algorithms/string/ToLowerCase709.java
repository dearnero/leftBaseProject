package com.hf.left.algorithms.string;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/18 21:53
 * @version: 1.0
 */
public class ToLowerCase709 {

    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch >= 65 && ch <= 90){
                ch += 32;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
