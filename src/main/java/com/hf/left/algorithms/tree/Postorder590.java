package com.hf.left.algorithms.tree;

import com.hf.left.algorithms.definition.NTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/6/27 09:43
 * @version: 1.0
 */
public class Postorder590 {

    public List<Integer> postorder(NTreeNode root) {

        List<Integer> result = new ArrayList<>();
        helper(result, root);
        return result;
    }

    public void helper(List<Integer> result, NTreeNode root){

        if (root == null) return;
        if (root.children != null){
            for (NTreeNode child : root.children) {
                helper(result, child);
            }
        }
        result.add(root.val);
    }
}
