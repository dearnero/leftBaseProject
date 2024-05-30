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
        for(int k = m + n - 1;k>=0;--k){
            if(j < 0 || (i >= 0 && num1[i] >= num2[j])){
                num1[k] = num1[i];
                i--;
            }else{
                num1[k] = num2[j];
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] num1 = {2,0};
        int[] num2 = {1};
        merge(num1, 1, num2,1);
        for (int i : num1) {
            System.out.println(i);
        }
    }
}
