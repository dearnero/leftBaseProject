package com.hf.left.hot;

import com.hf.left.algorithms.definition.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/8/22 09:40
 * @version: 1.0
 */
public class HPathSum {

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0L, 1);
        return dfs(root, 0, targetSum, prefixSumMap);
    }

    private int dfs(TreeNode root, long curSum, int targetSum, Map<Long, Integer> prefixSumMap) {
        if (root == null) return 0;
        curSum += root.val;
        int count = prefixSumMap.getOrDefault(curSum - targetSum, 0);
        prefixSumMap.put(curSum, prefixSumMap.getOrDefault(curSum, 0) + 1);
        count += dfs(root.left, curSum, targetSum, prefixSumMap);
        count += dfs(root.right, curSum, targetSum, prefixSumMap);
        prefixSumMap.put(curSum, prefixSumMap.get(curSum) - 1);
        return count;
    }

    public static void main(String[] args) {

    }
}
