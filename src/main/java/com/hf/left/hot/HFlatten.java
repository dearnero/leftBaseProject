package com.hf.left.hot;

import com.hf.left.algorithms.definition.TreeNode;

/**
 * @description: 114. 二叉树展开为链表
 * 1. 前序遍历，边查询边调整树结构
 * 2.
 * <a href="https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/description/?envType=study-plan-v2&envId=top-100-liked"></a>
 * @author: huang fu
 * @date: 2024/9/18 09:13
 * @version: 1.0
 */
public class HFlatten {

    public void flatten(TreeNode root) {
        if (root == null) return;
        subflatten(root);
    }

    private TreeNode subflatten(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode last = root;
        root.left = null;
        if (left != null){
            root.right = left;
            last = subflatten(left);
        }
        if (right != null){
            last.right = right;
            last = subflatten(right);
        }
        return last;
    }
}
