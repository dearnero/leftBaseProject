package com.hf.left.hot;

import com.hf.left.algorithms.definition.TreeNode;

/**
 * @description: 108. 将有序数组转换为二叉搜索树
 * 1. BST 的中序遍历是升序的，因此本题等同于根据中序遍历的序列恢复二叉搜索树。
 * 因此我们可以以升序序列中的任一个元素作为根节点，以该元素左边的升序序列构建左子树，
 * 以该元素右边的升序序列构建右子树，这样得到的树就是一棵二叉搜索树啦～ 又因为本题要求高度平衡，
 * 因此我们需要选择升序序列的中间元素作为根节点奥～
 * 2. 注意点：递归的终止条件为 if(l > r)
 * <a href = "https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/?envType=study-plan-v2&envId=top-100-liked"></a>
 * @author: huang fu
 * @date: 2024/9/17 15:25
 * @version: 1.0
 */
public class HSortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int l, int r) {
        if (l > r){
            return null;
        }
        int mid = l + (r - l )/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, l, mid - 1);
        root.right = dfs(nums, mid + 1, r);
        return root;
    }
}
