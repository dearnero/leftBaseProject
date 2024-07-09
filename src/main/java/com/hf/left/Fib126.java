package com.hf.left;

/**
 * final int MOD = 1000000007;
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/8 09:54
 * @version: 1.0
 */
public class Fib126 {

    public int fib(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        final int MOD = 1000000007;
        int l, r = 0;
        int ans = 1;
        for (int i = 2; i <= n; i++) {
            l = r;
            r = ans;
            ans =  (l + r) % MOD;
        }
        return ans;
    }

    public static void main(String[] args) {
        new Fib126().fib(5);
    }
}
