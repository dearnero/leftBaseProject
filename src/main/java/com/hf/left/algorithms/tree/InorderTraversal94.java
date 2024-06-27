package com.hf.left.algorithms.tree;

import com.hf.left.algorithms.definition.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/6/27 09:31
 * @version: 1.0
 */
public class InorderTraversal94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result  = new ArrayList<>();
        helper(root, result);
        return result;
    }

    public void helper(TreeNode root, List<Integer> result){
        if (root == null){
            return;
        }
        helper(root.left, result);
        result.add(root.val);
        helper(root.right, result);
    }
}
