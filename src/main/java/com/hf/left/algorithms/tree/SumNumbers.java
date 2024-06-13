package com.hf.left.algorithms.tree;

import com.hf.left.algorithms.definition.TreeNode;

/**
 * @description: 从根节点到叶节点的路径数字之和
 *：在一棵二叉树中所有节点都在0～9的范围之内，从根节点到叶节点的路径表示一个数字。求二叉树中所有路径表示的数字之和。
 *  例如，图8.4的二叉树有3条从根节点到叶节点的路径，它们分别表示数字395、391和302，这3个数字之和是1088。
 * @author: huang fu
 * @date: 2024/6/13 17:17
 * @version: 1.0
 */
public class SumNumbers {

    public Integer sumNumbers(TreeNode node){
        return dfs(node, 0);
    }

    private Integer dfs(TreeNode node, Integer path){
        if (node == null){
            return 0;
        }
        path = path * 10 + node.value;
        if (node.left == null && node.right == null){
            return path;
        }
        return dfs(node.left, path) + dfs(node.right, path);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        left.left =  new TreeNode(4);
        left.right =  new TreeNode(5);
        TreeNode right = new TreeNode(3);
        right.left =  new TreeNode(6);
        right.right =  new TreeNode(7);
        root.left = left;
        root.right = right;
        new SumNumbers().sumNumbers(root);
    }
}
