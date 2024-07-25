package com.hf.left.interview;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/25 13:53
 * @version: 1.0
 */
public class IIsHappy {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)){
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0){
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }
}
