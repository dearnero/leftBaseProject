package com.hf.left.algorithms.resursion;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/6/30 09:43
 * @version: 1.0
 */
public class ClimbStairs70 {

    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairsV2(int n){
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < n; i++) {
            p = q;
            q = r;
            r = q + p;
        }
        return r;
    }
}
