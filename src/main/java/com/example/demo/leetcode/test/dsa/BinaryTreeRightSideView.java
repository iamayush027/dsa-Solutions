package com.example.demo.leetcode.test.dsa;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    int maxLevel = 0;

    public static void main(String[] args) {
        int[] nodes = {1, 2,-1,3,4,-1,5};
        Tree tree = new Tree();
        TreeNode root = tree.buildTree(nodes);
        List<Integer> rightSideView=new ArrayList<>();
        tree.rightSideView(root,1,rightSideView);
        rightSideView.forEach(System.out::print);
    }


    static class Tree {
        static int index = -1;
        int maxLevel = 0;

        public TreeNode buildTree(int... nodes) {
            index++;
            if(index>= nodes.length) {
                return null;
            }
            if (nodes[index] == -1) {
                return null;
            }
            TreeNode newNode = new TreeNode(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;

        }

        public void rightSideView(TreeNode root, int level, List<Integer> list) {

            if (root == null)
                return;
            if (maxLevel < level) {
                list.add(root.data);
                maxLevel = level;
            }
            rightSideView(root.right, level + 1, list);
            rightSideView(root.left, level + 1, list);

        }
    }

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
