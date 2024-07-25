package com.hf.left.interview;

import com.hf.left.algorithms.definition.TreeNode;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/7/25 16:30
 * @version: 1.0
 */
public class ISsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }else if(p == null || q == null){
            return false;
        } else if (p.val != q.val){
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

}
