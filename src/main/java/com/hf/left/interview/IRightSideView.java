package com.hf.left.interview;

import com.hf.left.algorithms.definition.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/23 11:32
 * @version: 1.0
 */
public class IRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> level = new LinkedList<>();
        level.offerLast(root);
        while (!level.isEmpty()){
            int size = level.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = level.pop();
                if (i == size - 1) ans.add(pop.val);
                if (pop.left != null) level.offerLast(pop.left);
                if (pop.right != null) level.offerLast(pop.right);
            }
        }
        return ans;
    }
}
