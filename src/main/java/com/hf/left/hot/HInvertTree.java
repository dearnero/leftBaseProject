package com.hf.left.hot;

import com.hf.left.algorithms.definition.TreeNode;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/8/18 10:35
 * @version: 1.0
 */
public class HInvertTree {
    public TreeNode invertTree(TreeNode root){
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right= invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
