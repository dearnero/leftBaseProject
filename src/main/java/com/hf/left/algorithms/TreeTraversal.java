package com.hf.left.algorithms;

import java.util.*;

/**
 * @description:
 *         15
 *       /  \
 *     10    20
 *    /  \  /  \
 *   8   12 17  25
 * @author: huang fu
 * @date: 2024/5/27 16:13
 * @version: 1.0
 */
public class TreeTraversal {

    class Node{
        int value;

        Node left,right;

        public Node(int value){
            this.value = value;
        }
    }

    class RedBlackTree{

        private Node root;

        void insert(int value){
            root = insertRec(root, value);
        }

        Node insertRec(Node root, int value){
            if (root == null){
                root = new Node(value);
                return root;
            }
            if (value < root.value){
                root.left = insertRec(root.left, value);
            }else {
                root.right = insertRec(root.right, value);
            }
            return root;
        }

        void preOrder(Node node){
            if (node != null){
                System.out.println(node.value+" ");
                preOrder(node.left);
                preOrder(node.right);
            }
        }

        List<Integer> preOrderByStack(Node node){
            List<Integer> result = new LinkedList<>();
            Stack<Node> stack  = new Stack<>();
            Node cur = node;
            while (cur != null || !stack.isEmpty()){
                while (cur != null){
                    result.add(cur.value);
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                cur = cur.right;
            }
            return result;
        }

        void inOrder(Node node){
            if (node != null){
                inOrder(node.left);
                System.out.println(node.value + " ");
                inOrder(node.right);
            }
        }

        List<Integer> inOrderByStack(Node node){
            List<Integer> nodes = new LinkedList<>();
            Stack<Node> stack = new Stack<>();
            Node cur = node;
            while (cur != null || !stack.isEmpty()){
                while (cur != null){
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                nodes.add(cur.value);
                cur = cur.right;
            }
            return nodes;
        }

        void postOrder(Node node){
            if (node != null){
                postOrder(node.left);
                postOrder(node.right);
                System.out.println(node.value + " ");
            }
        }

        List<Integer> postOrderByStack(Node node){
            List<Integer> result = new LinkedList<>();
            Stack<Node> stack = new Stack<>();
            Node cur = node;
            Node prev = null;
            while (cur != null || !stack.isEmpty()){
                while (cur != null){
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.peek();
                if (cur.right != null && cur.right != prev){
                    cur = cur.right;
                }else {
                    stack.pop();
                    result.add(cur.value);
                    prev = cur;
                    cur = null;
                }

            }
            return result;
        }

        void leverOrder(){
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                Node poll = queue.poll();
                if (poll.left != null){
                    queue.add(poll.left);

                }
                if (poll.right != null){
                    queue.add(poll.right);
                }
            }
        }
    }

    /**
     * 二叉树中每层的最大值
     */
    public List<Integer> largestValues(Node root){
        int current = 0;
        int next = 0;
        Queue<Node> queue = new LinkedList<>();
        if (root != null){
            queue.offer(root);
            current = 1;
        }
        List<Integer> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()){
            Node node = queue.poll();
            current--;
            max = Math.max(max, node.value);
            if (node.left !=null){
                queue.offer(node.left);
                next++;
            }
            if (node.right != null){
                queue.offer(node.right);
                next++;
            }
            if (current == 0){
                result.add(max);
                max = Integer.MIN_VALUE;
                current = next;
                next = 0;
            }
        }
        return result;
    }

    public List<Integer> largestValues2(Node root) {

        Queue<Node> queue1 = new LinkedList<>();
        if (root != null){
            queue1.offer(root);
        }
        List<Integer> result = new ArrayList<>();
        Queue<Node> queue2 = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        while (!queue1.isEmpty()){
            Node node = queue1.poll();
            max = Math.max(max, node.value);
            if (node.left != null){
                queue2.add(node.left);
            }
            if (node.right != null){
                queue2.add(node.right);
            }
            if (queue1.isEmpty()){
                result.add(max);
                max = Integer.MIN_VALUE;
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return result;
    }

    /**
     * 二叉树最低层最左边的值
     */
    public int findBottomLeftValue(Node node){
        Queue<Node> queue1 = new LinkedList<>();
        queue1.offer(node);
        int leftValue = node.value;
        Queue<Node> queue2 = new LinkedList<>();
        while (!queue1.isEmpty()){
            Node poll = queue1.poll();
            if (poll.left != null){
                queue2.offer(poll.left);
            }
            if (poll.right != null){
                queue2.offer(poll.right);
            }
            if (queue1.isEmpty()){
                queue1 = queue2;
                if (!queue2.isEmpty()){
                    Node peek = queue2.peek();
                    leftValue = peek.value;
                }
                queue2 = new LinkedList<>();
            }
        }
        return leftValue;
    }

    public static void main(String[] args) {

//        RedBlackTree tree = new TreeTraversal().new RedBlackTree();
//        tree.insert(15);
//        tree.insert(10);
//        tree.insert(20);
//        tree.insert(8);
//        tree.insert(12);
//        tree.insert(17);
//        tree.insert(25);
//
//
//
//
//        System.out.println("Pre-order traversal:");
//        tree.preOrder(tree.root);  // Output: 15 10 8 12 20 17 25

        Node root = new TreeTraversal().new Node(1);
        Node left = new TreeTraversal().new Node(2);
        left.left =  new TreeTraversal().new Node(4);
        left.right =  new TreeTraversal().new Node(5);
        Node right = new TreeTraversal().new Node(2);
        right.left =  new TreeTraversal().new Node(6);
        right.right =  new TreeTraversal().new Node(7);
        root.left = left;
        root.right = right;

        new TreeTraversal().new RedBlackTree().inOrderByStack(root);
    }
}
