package com.hf.left.algorithms.definition;

import java.util.List;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/6/27 09:40
 * @version: 1.0
 */
public class NTreeNode {

    public int val;
    public List<NTreeNode> children;

    public NTreeNode() {}

    public NTreeNode(int _val) {
        val = _val;
    }

    public NTreeNode(int _val, List<NTreeNode> _children) {
        val = _val;
        children = _children;
    }
}
