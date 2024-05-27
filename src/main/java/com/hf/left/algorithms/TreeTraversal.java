package com.hf.left.algorithms;

import java.util.LinkedList;
import java.util.Queue;

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

        void inOrder(Node node){
            if (node != null){
                inOrder(node.left);
                System.out.println(node.value + " ");
                inOrder(node.right);
            }
        }

        void postOrder(Node node){
            if (node != null){
                postOrder(node.left);
                postOrder(node.right);
                System.out.println(node.value + " ");
            }
        }

        void leverOrder(){
            if (root != null){
                return;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                Node current = queue.poll();
                System.out.println(current.value + " ");
                if (current.left != null){
                    queue.add(current.left);
                }
                if (current.right != null){
                    queue.add(current.right);
                }
            }
        }
    }

    public static void main(String[] args) {

        RedBlackTree tree = new TreeTraversal().new RedBlackTree();
        tree.insert(15);
        tree.insert(10);
        tree.insert(20);
        tree.insert(8);
        tree.insert(12);
        tree.insert(17);
        tree.insert(25);

        System.out.println("Pre-order traversal:");
        tree.preOrder(tree.root);  // Output: 15 10 8 12 20 17 25
    }
}
