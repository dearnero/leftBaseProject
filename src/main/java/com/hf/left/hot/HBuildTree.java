package com.hf.left.hot;

import com.hf.left.algorithms.definition.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 105. 从前序与中序遍历序列构造二叉树
 * 1. 很锻炼对于树形结构的操作
 * 2. 关键在于找到左右子树，然后采用递归进行处理
 * <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/?envType=study-plan-v2&envId=top-100-liked"></a>
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
