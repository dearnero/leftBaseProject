package com.hf.left.hot;

import com.hf.left.algorithms.definition.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 230. 二叉搜索树中第 K 小的元素
 * 1. 树的中序遍历可转化为递增数组，再通过对比 k,获取到结果
 * <a href = "https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/?envType=study-plan-v2&envId=top-100-liked"></a>
 * @author: huang fu
 * @date: 2024/9/18 08:58
 * @version: 1.0
 */
public class HKthSmallest {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> temp = new ArrayList<>();
        dfs(root, temp);
        for (int i = 0; i < temp.size(); i++) {
            if (i == k - 1) return temp.get(i);
        }
        return -1;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null){
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

}
