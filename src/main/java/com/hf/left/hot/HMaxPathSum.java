package com.hf.left.hot;

import com.hf.left.algorithms.definition.TreeNode;

/**
 * @description: 124. 二叉树中的最大路径和
 * 1. 递归的方式执行
 * 2. 通过对比左右子树的和，与当前值大小，来判断出当前子树的最大和
 * <a href="https://leetcode.cn/problems/binary-tree-maximum-path-sum/solutions/297005/er-cha-shu-zhong-de-zui-da-lu-jing-he-by-leetcode-/?envType=study-plan-v2&envId=top-100-liked"></a>
 * @author: huang fu
 * @date: 2024/9/20 12:05
 * @version: 1.0
 */
public class HMaxPathSum {

    private int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int lfSum = Math.max(dfs(root.left), 0);
        int rtSum = Math.max(dfs(root.right), 0);
        ans = Math.max(ans, root.val + lfSum + rtSum);
        return root.val + Math.max(lfSum, rtSum);
    }


}
