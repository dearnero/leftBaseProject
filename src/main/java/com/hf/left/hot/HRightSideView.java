package com.hf.left.hot;

import com.hf.left.algorithms.definition.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/8/18 10:47
 * @version: 1.0
 */
public class HRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = deque.pop();
                if (i == size - 1) ans.add(pop.val);
                if (pop.left != null) deque.offerLast(pop.left);
                if (pop.right != null) deque.offerLast(pop.right);
            }
        }
        return ans;
    }
}
