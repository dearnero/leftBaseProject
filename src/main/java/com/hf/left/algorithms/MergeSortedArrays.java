package com.hf.left.algorithms;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/5/18 09:16
 * @v ersion: 1.0
 */
public class MergeSortedArrays {

    public static void merge(int[] num1, int m, int[] num2, int n){
        int i = m - 1;
        int j = n - 1;
        int tail = m + n - 1;
        int cur = 0;
        while (i >= 0 || j >=0){
            if (i == -1){
                cur = num2[j--];
            }else if (j == -1){
                cur = num1[i--];
            }else if (num1[i] >= num2[j]){
                cur = num1[i--];
            }else {
                cur = num2[j--];
            }
            num1[tail--] = cur;
        }
    }

    public static void main(String[] args) {
        int[] num1 = {0};
        int[] num2 = {1};
        merge(num1, 0, num2,1);
        for (int i : num1) {
            System.out.println(i);
        }
    }
}
