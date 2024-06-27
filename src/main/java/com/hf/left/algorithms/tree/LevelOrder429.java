package com.hf.left.algorithms.tree;

import com.hf.left.algorithms.definition.NTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/6/27 10:17
 * @version: 1.0
 */
public class LevelOrder429 {

    public List<List<Integer>> levelOrder(NTreeNode root) {

        Queue<NTreeNode> queue = new LinkedList<>();
        Queue<NTreeNode> nextQueue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        List<List<Integer>> treeList = new ArrayList<>();
        List<Integer> levelList = new ArrayList<>();
        while (!queue.isEmpty()){
            NTreeNode poll = queue.poll();
            levelList.add(poll.val);
            if (poll.children != null){
                nextQueue.addAll(poll.children);
            }
            if (queue.isEmpty()){
                queue = nextQueue;
                treeList.add(levelList);
                levelList = new ArrayList<>();
                nextQueue = new LinkedList<>();
            }
        }
        return treeList;
    }

    public static void main(String[] args) {
        //  [1,null,3,2,4,null,5,6]
        NTreeNode root = new NTreeNode(1);
        NTreeNode level1 = new NTreeNode(3);
        NTreeNode level2 = new NTreeNode(2);
        NTreeNode level3 = new NTreeNode(4);
        root.children = new ArrayList<NTreeNode>(){{
            add(level1);add(level2);add(level3);
        }};
        level3.children = new ArrayList<NTreeNode>(){{
            add(new NTreeNode(5)); add(new NTreeNode(6));
        }};
        new LevelOrder429().levelOrder(root);
    }
}
