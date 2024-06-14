package com.hf.left.algorithms.tree;

import com.hf.left.algorithms.definition.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 向下的路径节点值之和
 * 给定一棵二叉树和一个值sum，求二叉树中节点值之和等于sum的路径的数目。
 * 路径的定义为二叉树中顺着指向子节点的指针向下移动所经过的节点，但不一定从根节点开始，也不一定到叶节点结束。
 * 例如，在如图8.5所示中的二叉树中有两条路径的节点值之和等于8，
 * 其中，第1条路径从节点5开始经过节点2到达节点1，第2条路径从节点2开始到节点6。
 *
 * @author: huang fu
 * @date: 2024/6/14 09:43
 * @version: 1.0
 */
public class PathSum {

    public int pathSum(TreeNode root, int sum){
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        return dfs(root, sum, hashMap, 0);
    }

    private int dfs(TreeNode root, int target, Map<Integer, Integer> map, int prefixSum) {
        if (root == null){
            return 0;
        }
        prefixSum += root.value;
        int count = map.getOrDefault(prefixSum - target, 0);
        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        count += dfs(root.left, target, map, prefixSum);
        count += dfs(root.right, target, map, prefixSum);
        map.put(prefixSum, map.get(prefixSum) - 1);
        return count;
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
        System.out.println(new PathSum().pathSum(root, 7));
    }
}
