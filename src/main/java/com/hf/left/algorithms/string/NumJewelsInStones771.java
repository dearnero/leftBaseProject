package com.hf.left.algorithms.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/18 22:06
 * @version: 1.0
 */
public class NumJewelsInStones771 {
    public int numJewelsInStones(String jewels, String stones) {

        Set<Character> set = new HashSet<>();
        for (char c : jewels.toCharArray()) {
            set.add(c);
        }
        int count = 0;
        for (char c : stones.toCharArray()) {
            if (set.contains(c)){
                count++;
            }
        }
        return count;
    }
}
