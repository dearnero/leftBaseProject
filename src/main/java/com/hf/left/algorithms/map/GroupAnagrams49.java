package com.hf.left.algorithms.map;

import java.util.*;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/6/26 19:32
 * @version: 1.0
 */
public class GroupAnagrams49 {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> result = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            List<String> list = result.getOrDefault(key, new ArrayList<>());
            list.add(str);
            result.put(key, list);
        }
        return new ArrayList<>(result.values());
    }
}
