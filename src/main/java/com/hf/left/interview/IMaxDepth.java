package com.hf.left.interview;

import com.hf.left.algorithms.definition.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/22 22:46
 * @version: 1.0
 */
public class IMaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> level = new LinkedList<>();
        level.offerLast(root);
        int depth = 0;
        while (!level.isEmpty()){
            int size = level.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = level.pop();
                if (pop.left != null) level.offerLast(pop.left);
                if (pop.right != null) level.offerLast(pop.right);
            }
            depth++;
        }
        return depth;
    }
}
