package com.hf.left.hot;

import com.hf.left.algorithms.definition.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/9/19 10:28
 * @version: 1.0
 */
public class HBuildTree {

    private Map<Integer, Integer> inOrderMap;

    public TreeNode buildTree(int[] preOrder, int[] inOrder){
        int n = preOrder.length;
        inOrderMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inOrderMap.put(inOrder[i], i);
        }
        return dfs(preOrder, inOrder, 0, n - 1, 0, n - 1);
    }

    private TreeNode dfs(int[] preOrder, int[] inOrder,
                     int preOrderLeft, int preOrderRight, int inOrderLeft, int inOrderRight) {
        if (preOrderLeft > preOrderRight) return null;
        TreeNode root = new TreeNode(preOrder[preOrderLeft]);
        int inOrderRoot = inOrderMap.get(preOrder[preOrderLeft]);
        int leftSize = inOrderRoot - inOrderLeft;
        root.left = dfs(preOrder, inOrder,
                preOrderLeft + 1, preOrderLeft + leftSize, inOrderLeft, inOrderRoot - 1);
        root.right = dfs(preOrder, inOrder,
                preOrderLeft + leftSize + 1, preOrderRight, inOrderRoot + 1, inOrderRight);
        return root;
    }

}
