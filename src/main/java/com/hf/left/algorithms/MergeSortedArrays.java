package com.hf.left.algorithms;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/5/18 09:16
 * @v ersion: 1.0
 */
public class MergeSortedArrays {

    public static void merge(int[] num1, int m, int[] num2, int n){
        int p1 = m - 1;
        int p2 = n - 1;
        for (int k = m + n -1; k >= 0; k--){
            if (p2 < 0 || (p1 > 0 && num1[p1] >= num2[p2])){
                num1[k] = num1[p1];
                p1--;
            }else {
                num1[k] = num2[p2];
                p2--;
            }
        }
    }

    public static void main(String[] args) {
        int[] num1 = {1,2,4,0,0,0};
        int[] num2 = {3,7,8};
        merge(num1, 3, num2,3);
        for (int i : num1) {
            System.out.println(i);
        }
    }
}
