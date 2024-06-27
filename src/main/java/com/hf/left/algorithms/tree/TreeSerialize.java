package com.hf.left.algorithms.tree;

import com.hf.left.algorithms.definition.TreeNode;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/6/13 10:37
 * @version: 1.0
 */
public class TreeSerialize {

    public String serialize(TreeNode node){
        if (node == null){
            return "#";
        }
        String leftStr = serialize(node.left);
        String rightStr = serialize(node.right);
        return String.valueOf(node.val) + "," + leftStr + "," + rightStr;
    }

    public TreeNode deserialize(String data){
        String[] nodeStrs = data.split(",");
        int[] i = {0};
        return dfs(nodeStrs,  i);
    }

    private TreeNode dfs(String[] nodeStr, int[] i) {
        String str = nodeStr[i[0]];
        i[0]++;
        if (str.equals("#")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(str));
        node.left = dfs(nodeStr, i);
        node.right = dfs(nodeStr, i);
        return node;
    }
}
