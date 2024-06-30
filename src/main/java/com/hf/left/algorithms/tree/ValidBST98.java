package com.hf.left.algorithms.tree;

import com.hf.left.algorithms.definition.TreeNode;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/6/30 10:44
 * @version: 1.0
 */
public class ValidBST98 {

    private long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        if (!isValidBST(root.left) || root.val <= pre){
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }
}
