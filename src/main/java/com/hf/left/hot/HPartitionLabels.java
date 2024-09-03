package com.hf.left.hot;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 763. 划分字母区间
 * 1. 使用一个数组保存每个字母最后出现的位置
 * 2. 执行分段操作，通过循环，判断当前字母与最后出现位置的最大值，按照最大值进行分段
 * @link <a href = "https://leetcode.cn/problems/partition-labels/description/?envType=study-plan-v2&envId=top-100-liked"></a>
 * @author: huang fu
 * @date: 2024/9/3 15:21
 * @version: 1.0
 */
public class HPartitionLabels {

    public List<Integer> partitionLabels(String s) {
        int[] temp = new int[26];
        for (int i = 0; i < s.length(); i++) {
            temp[s.charAt(i) - 'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, temp[s.charAt(i) - 'a']);
            if (i == end){
                ans.add(end - start + 1);
                start = end + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new HPartitionLabels().partitionLabels("abca");
    }
}
