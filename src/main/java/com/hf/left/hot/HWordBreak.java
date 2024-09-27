package com.hf.left.hot;

import java.util.Arrays;
import java.util.List;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/9/27 10:12
 * @version: 1.0
 */
public class HWordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    // 回溯的算法会超过时间限制
    public boolean wordBreak1(String s, List<String> wordDict) {
        return dfs(s, wordDict, 0);
    }

    private boolean dfs(String s, List<String> wordDict, int idx) {
        if (idx == s.length()){
            return true;
        }
        for (int i = 0; i < wordDict.size(); i++) {
            String word = wordDict.get(i);
            if (idx + word.length() <= s.length() && word.equals(s.substring(idx, idx + word.length()))){
                if (dfs(s, wordDict, idx + word.length())){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(new HWordBreak().wordBreak("catsandog", Arrays.asList(new String[]{"cats","dog","sand","and","cat"})));;
    }


}
