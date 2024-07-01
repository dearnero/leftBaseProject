package com.hf.left.algorithms.resursion;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/1 15:54
 * @version: 1.0
 */
public class MyPow50 {

    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return helper(x, N);
    }

    private double helper(double x, long n) {
        if (n == 0) return 1.0;
        double h = helper(x, n / 2);
        return n % 2 == 1 ? h * h * x : h * h;
    }

    public static void main(String[] args) {
        System.out.println(new MyPow50().myPow(2.0000, 10));
    }
}
