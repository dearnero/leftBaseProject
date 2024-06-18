package com.hf.left.algorithms.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/6/18 21:54
 * @version: 1.0
 */
public class ClimbStairs70 {

    public int climbStairs(int n){
        return subClimbStairs(n, new HashMap<>());
    }

    private int subClimbStairs(int n , Map<Integer, Integer> temp){
        if (n == 1 || n == 2){
            return n;
        }
        if (temp.containsKey(n)){
            return temp.get(n);
        }
        int result = climbStairs(n - 1) + climbStairs(n - 2);
        temp.put(n,result);
        return result;
    }

    public int climbStairs2(int n){
        int p = 0, q=0, r = 1;
        for (int i = 1; i < n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
