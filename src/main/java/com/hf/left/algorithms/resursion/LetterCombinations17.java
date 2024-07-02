package com.hf.left.algorithms.resursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/1 16:56
 * @version: 1.0
 */
public class LetterCombinations17 {

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return null;
        }
        Map<Character, String> dirt = new HashMap<>();
        dirt.put('2', "abc");
        dirt.put('3', "def");
        dirt.put('4', "ghi");
        dirt.put('5', "jkl");
        dirt.put('6', "mno");
        dirt.put('7', "pqsr");
        dirt.put('8', "tuv");
        dirt.put('9', "wxyz");
        List<String> result = new ArrayList<>();
        help("", digits, 0, result, dirt);
        return result;
    }

    private void help(String s, String digits, int level, List<String> result, Map<Character, String> dirt){
        if (level == digits.length()){
            result.add(s);
            return;
        }
        String s1 = dirt.get(digits.charAt(level));
        for (int i = 0; i < s1.toCharArray().length; i++) {
            help(s + s1.charAt(i), digits, level + 1, result, dirt);
        }
    }
}
