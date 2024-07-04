package com.hf.left.algorithms.tree;

import com.hf.left.algorithms.definition.TreeNode;

import java.util.*;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/4 09:54
 * @version: 1.0
 */
public class LevelOrder102 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        helper(root, ans);
        return ans;
    }

    private void helper1(TreeNode root, List<List<Integer>> ans) {
        Deque<TreeNode> nowLevel = new LinkedList<>();
        nowLevel.add(root);
        Deque<TreeNode> nextLevel = new LinkedList<>();
        while (!nowLevel.isEmpty()){
            List<Integer> levelAns = new ArrayList<>();
            for (TreeNode node : nowLevel) {
                levelAns.add(node.val);
                if (node.left != null){
                    nextLevel.addLast(node.left);
                }
                if (node.right != null){
                    nextLevel.addLast(node.right);
                }
            }
            ans.add(levelAns);
            nowLevel = nextLevel;
            nextLevel = new LinkedList<>();
        }
    }

    private void helper(TreeNode root, List<List<Integer>> ans) {
        Deque<TreeNode> nowLevel = new LinkedList<>();
        nowLevel.add(root);
        Deque<TreeNode> nextLevel = new LinkedList<>();
        List<Integer> levelAns = new ArrayList<>();
        while (!nowLevel.isEmpty()){
            TreeNode node = nowLevel.pollFirst();
            levelAns.add(node.val);
            if (node.left != null){
                nextLevel.addLast(node.left);
            }
            if (node.right != null){
                nextLevel.addLast(node.right);
            }
            if (nowLevel.isEmpty()){
                ans.add(new ArrayList<>(levelAns));
                levelAns = new ArrayList<>();
                nowLevel = nextLevel;
                nextLevel = new LinkedList<>();
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        //
        TreeNode o1 = new TreeNode(9);
        TreeNode o2 = new TreeNode(20);
        root.left = o1;
        root.right = o2;

        TreeNode t1 = new TreeNode(15);
        TreeNode t2 = new TreeNode(7);
        o2.left = t1;
        o2.right = t2;
        System.out.println(new LevelOrder102().levelOrder(root));
    }
}
