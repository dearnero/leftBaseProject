package com.hf.left.hot;

import com.hf.left.algorithms.definition.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/8/18 09:49
 * @version: 1.0
 */
public class HMaxDepth {
    public int maxDepth(TreeNode root) {
        int ans = 0;
        if (root == null) return ans;
        Deque<TreeNode> kk = new LinkedList<>();
        kk.offerLast(root);
        while (!kk.isEmpty()){
            int size = kk.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = kk.pop();
                if (pop.left != null) kk.offerLast(pop.left);
                if (pop.right != null) kk.offerLast(pop.right);
            }
            ans++;
        }
        return ans;
    }

    public int maxDepth2(TreeNode root){
        if (root == null){
            return 0;
        }else{
            int i = maxDepth2(root.left);
            int j = maxDepth2(root.right);
            return Math.max(i,j) + 1;
        }
    }
}
