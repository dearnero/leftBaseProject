package com.hf.left.hot;

import com.hf.left.algorithms.definition.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/8/18 08:54
 * @version: 1.0
 */
public class HInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans  = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        dfs(root.left, ans);
        ans.add(root.val);
        dfs(root.right, ans);
    }
}
