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

    public List<String> generateParenthesis(int n){

        List<String> ans = new ArrayList<>();
        helper(n, "", ans, 0, 0);
        return ans;
    }

    void helper(int n, String s, List<String> ans, int left, int right){

        if (s.length() == 2 * n){
            ans.add(s);
            return;
        }
        if(left < n){
            helper(n, s + "(", ans, left+1, right);
        }
        if (right < left){
            helper(n, s + ")", ans, left, right+1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis22().generateParenthesis(2));
    }
}
