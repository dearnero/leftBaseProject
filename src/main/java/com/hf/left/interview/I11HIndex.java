package com.hf.left.interview;

import java.util.Arrays;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/15 14:41
 * @version: 1.0
 */
public class I11HIndex {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        for (int i = citations.length - 1; i >=0; i--) {
            if (citations[i] <= h){
                break;
            }
            h++;
        }
        return h;
    }

    public static void main(String[] args) {
        new I11HIndex().hIndex(new int[]{1,1,3});
    }
}
