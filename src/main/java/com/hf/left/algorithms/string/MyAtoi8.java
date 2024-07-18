package com.hf.left.algorithms.string;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/18 22:26
 * @version: 1.0
 */
public class MyAtoi8 {
    public int myAtoi(String s) {
        int index = 0, sign = 1, total = 0;
        if (s.length() == 0) return 0;
        // 去空格
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        // 定符号
        if (s.length() > index && (s.charAt(index) == '+' || s.charAt(index) == '-')){
            sign = s.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        // 提取数字
        while (index < s.length()){
            int digit = s.charAt(index) - '0';
            if (digit < 0 || digit > 9) break;
            // 判断是否溢出
            if (total > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = total * 10 + digit;
            index++;
        }
        return total * sign;
    }

    public static void main(String[] args) {
        new MyAtoi8().myAtoi(" ");
    }
}
