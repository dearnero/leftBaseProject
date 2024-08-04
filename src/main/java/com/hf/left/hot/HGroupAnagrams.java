package com.hf.left.hot;

import java.util.*;

/**
 * @description: 49. 字母异位词分组
 * @link <a href= "https://leetcode.cn/problems/group-anagrams/solutions/?envType=study-plan-v2&envId=top-100-liked"></a>
 * @author: huang fu
 * @date: 2024/8/4 10:51
 * @version: 1.0
 */
public class HGroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> memo = new HashMap<>();
        for (String str : strs) {
            char[] kk = str.toCharArray();
            Arrays.sort(kk);
            String key = new String(kk);
            List<String> list = memo.getOrDefault(key, new ArrayList<>());
            list.add(str);
            memo.put(key, list);
        }
        return new ArrayList<>(memo.values());
    }
}
