package com.hf.left.algorithms.resursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/6/30 10:00
 * @version: 1.0
 */
public class GenerateParenthesis22 {

    private List<String> result;

    public List<String> generateParenthesis(int n){
        result = new ArrayList<>();
        generate(0, 0 , n, "");
        return result;
    }

    private void generate(int left, int right, int n, String s) {
        // terminator
        if (left == n && right == n){
            result.add(s);
            return;
        }
        // drill down
        if (left < n){
            generate(left + 1, right, n, s + "(");
        }
        if (right < left){
            generate(left,right + 1, n, s + ")");
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis22().generateParenthesis(3));
    }
}
