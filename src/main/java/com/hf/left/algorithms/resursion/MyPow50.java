package com.hf.left.algorithms.resursion;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/1 15:54
 * @version: 1.0
 */
public class MyPow50 {

    public double myPow(double x, int n) {

        if (n < 0){
            n = -n;
            x = 1/x;
        }
        return helper(x, n);
    }

    private double helper(double x, int n){
        if (n == 0) {
            return 1.0;
        }
        double half = helper(x, n / 2);
        return n %2 == 0 ? half * half : half * half * x;
    }

    public static void main(String[] args) {
        System.out.println(new MyPow50().myPow(2.0000, 10));
    }
}
