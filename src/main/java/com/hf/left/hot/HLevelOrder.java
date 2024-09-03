package com.hf.left.hot;

import com.hf.left.algorithms.definition.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/9/3 14:42
 * @version: 1.0
 */
public class HLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            List<Integer> levelAns = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode pop = deque.pop();
                levelAns.add(pop.val);
                if (pop.left != null) deque.offerLast(pop.left);
                if (pop.right != null) deque.offerLast(pop.right);
            }
            ans.add(levelAns);
        }
        return ans;
    }
}
