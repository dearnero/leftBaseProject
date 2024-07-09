package com.hf.left;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/7 13:53
 * @version: 1.0
 */
public class MySqrt072 {

    public int mySqrt(int x) {
        if(x == 0 || x == 1){
            return x;
        }
        long  left = 1;
        long  right = x;
        while (left <= right){
            long mid = left + (right - left) /2;
            if (mid * mid > x){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return (int)right;
    }

    public static void main(String[] args) {
        System.out.println(new MySqrt072().mySqrt(8));
    }
}
