package com.hf.left.hot;

import com.hf.left.algorithms.definition.TreeNode;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/8/31 16:55
 * @version: 1.0
 */
public class HIsValidBST {

    public boolean isValidBST(TreeNode root) {

        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, Long minValue, Long maxValue) {
        if (root == null) {
            return true;
        }
        if (root.val <= minValue || root.val >= maxValue){
            return false;
        }
        return isValidBST(root.left, minValue, Long.valueOf(root.val)) && isValidBST(root.right, Long.valueOf(root.val), maxValue);
    }

    public static void main(String[] args) {
        HIsValidBST h = new HIsValidBST();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        h.isValidBST(root);
    }
}