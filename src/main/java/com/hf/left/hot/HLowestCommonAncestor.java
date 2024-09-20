package com.hf.left.hot;

import com.hf.left.algorithms.definition.TreeNode;

/**
 * @description: 236. 二叉树的最近公共祖先
 * 1. 使用递归的方式进行，按照如下公式进行判定:
 * (f(l) && f(r)) || ((root == p || root == q) && (f(l) || f(r)))
 * <a href ="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked"></a>
 * @author: huang fu
 * @date: 2024/9/20 09:47
 * @version: 1.0
 */
public class HLowestCommonAncestor {

    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if (lson && rson || ((root.val == p.val || root.val == q.val) && (lson || rson))){
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }
}
