package com.hf.left;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/8 09:54
 * @version: 1.0
 */
public class Fib126 {

    public int fib(int n) {
        if(n == 0 || n == 1) return n;
        final int MOD = 1000000007;
        int[] ans = new int[n + 1];
        ans[0] = 0;
        ans[1] = 1;
        for(int k = 2; k <= n; k++){
            ans[k] = (ans[k - 1] + ans[k - 2]) % MOD;
        }
        return ans[n];
    }

    public int fib2(int n){
        if (n == 0 || n == 1)return n;
        final int MOD = 1000000007;
        int a = 0;
        int b = 0;
        int c = 1;
        for (int i = 2; i < n; i++) {
            a = b;
            b = c;
            c = (a + b) % MOD;
        }
        return c;
    }

    public static void main(String[] args) {
        new Fib126().fib(45);
    }
}
