package com.example.demo.leetcode.test;

import com.example.demo.leetcode.test.dsa.SymmetricTree;

import java.util.*;
import java.util.concurrent.Semaphore;

public class BinaryTree {
    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Tree tree = new Tree();
        Node root = tree.buildTree(nodes);
        tree.preOrderTraverse(root);
        System.out.println("");
//
        tree.inOrderTraverse(root);
        System.out.println("");
        tree.postOrderTraverse(root);
        System.out.println("");
        tree.levelOrderTraverse(root);
        System.out.println("");
//        System.out.println(tree.countNodes(root));
//        System.out.println("");
//        System.out.println("HEIGHT: "+tree.heightOfTree(root));
//        System.out.println("ROOT: " + root.data);
        System.out.println("Diameter: "+diameterOfBinaryTree(root));
    }

    private static int diameterOfBinaryTree(Node root) {
        int[] diameter = new int[1];
       findDiameter(root, diameter);
        return diameter[0];
    }

    public static int findDiameter(Node root, int[] diameter) {
        if (root == null) {
            return 0;
        }
        int left = findDiameter(root.left, diameter);
        int right = findDiameter(root.right, diameter);
        diameter[0] = Math.max(diameter[0], left + right);
        return Math.max(right, left) +1;

    }


    public static class Node {
        public int data;
        public Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class Tree {
        static int index = -1;

        private static void levelOrderTraverse(Node root) {
            Queue<Node> queue = new LinkedList<>();
            if (root == null) return;
            queue.add(root);
            queue.add(null);
            while (!queue.isEmpty()) {
                Node currNode = queue.remove();
                if (currNode == null) {
                    if (queue.isEmpty()) {
                        break;
                    } else {
                        System.out.println("");
                        queue.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        queue.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        queue.add(currNode.right);
                    }
                }
            }

        }

        public Node buildTree(int... nodes) {
            index++;
            if (nodes[index] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;

        }

        public void preOrderTraverse(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data);
            preOrderTraverse(root.left);
            preOrderTraverse(root.right);
        }

        public void inOrderTraverse(Node root) {
            if (root == null) {
                return;
            }
            inOrderTraverse(root.left);
            System.out.print(root.data);
            inOrderTraverse(root.right);
        }

        public void postOrderTraverse(Node root) {
            if (root == null) {
                return;
            }
            postOrderTraverse(root.left);
            postOrderTraverse(root.right);
            System.out.print(root.data);

        }

        public int heightOfTree(Node root) {
            if (root == null) return 0;
            int left = heightOfTree(root.left);
            int right = heightOfTree(root.right);
            return Math.max(left, right) + 1;
        }

        public int countNodes(Node root) {
            if (root == null) {
                return 0;
            }
            int leftNode = countNodes(root.left);
            int rightNode = countNodes(root.right);
            return leftNode + rightNode + 1;
        }

    }
}
