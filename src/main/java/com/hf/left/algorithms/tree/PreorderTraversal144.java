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
public class PreorderTraversal144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result  = new ArrayList<>();
        helper(root, result);
        return result;
    }

    public void helper(TreeNode root, List<Integer> result){
        if (root == null){
            return;
        }
        result.add(root.val);
        helper(root.left, result);
        helper(root.right, result);
    }
}
