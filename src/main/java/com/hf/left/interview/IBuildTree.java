package com.hf.left.interview;

import com.hf.left.algorithms.definition.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/25 16:38
 * @version: 1.0
 */
public class IBuildTree {

    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder,
                                 int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) return null;
        int preOrderRoot = preorder_left;
        TreeNode root = new TreeNode(preorder[preOrderRoot]);
        int inOrderRoot = indexMap.get(preorder[preOrderRoot]);
        int inOrder_left_size = inOrderRoot - inorder_left;
        root.left = myBuildTree(preorder, inorder,
                preorder_left + 1, preorder_left + inOrder_left_size, inorder_left, inOrderRoot - 1);
        root.right = myBuildTree(preorder, inorder,
                preorder_left + inOrder_left_size + 1, preorder_right, inOrderRoot + 1, inorder_right);
        return root;
    }
}
