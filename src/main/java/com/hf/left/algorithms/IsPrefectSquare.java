package com.hf.left.algorithms;

/**
 * @description: 367
 * 有效的平方数
 * @author: huang fu
 * @date: 2024/6/16 16:06
 * @version: 1.0
 */
public class IsPrefectSquare {

    public boolean isPerfectSquare(int num){
        if (num == 0 || num == 1){
            return true;
        }
        int left = 1;
        int right = num;
        while (left <= right){
            int mid = (left + right) /2;
            long square = (long) mid * mid;
            if (square == num){
                return true;
            }else if (square < num){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new IsPrefectSquare().isPerfectSquare(104976);
    }
}
