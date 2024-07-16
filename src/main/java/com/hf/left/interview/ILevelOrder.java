package com.hf.left.interview;

import com.hf.left.algorithms.definition.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/16 10:08
 * @version: 1.0
 */
public class ILevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        LinkedList<TreeNode> curLevel = new LinkedList<>();
        curLevel.push(root);
        LinkedList<TreeNode> nextLevel = new LinkedList<>();
        List<Integer> levelAns = new ArrayList<>();
        while (!curLevel.isEmpty()){
            TreeNode pop = curLevel.pop();
            levelAns.add(pop.val);
            if (pop.left != null) nextLevel.offerLast(pop.left);
            if (pop.right != null) nextLevel.offerLast(pop.right);
            if (curLevel.isEmpty()){
                ans.add(levelAns);
                levelAns = new ArrayList<>();
                curLevel = nextLevel;
                nextLevel = new LinkedList<>();
            }
        }
        return ans;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()){
            List<Integer> levelAns = new ArrayList<>();
            int size = deque.size();
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
