package com.example.demo.leetcode.test.dsa;

import com.example.demo.leetcode.test.BinaryTree;

public class MaxAvgSubTree {
    static double max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree.Tree tree = new BinaryTree.Tree();
        BinaryTree.Node root = tree.buildTree(nodes);
        findMaxAvgSubTree(root);
        System.out.println("Max avg subtree: "+max);

    }

    private static double[] findMaxAvgSubTree(BinaryTree.Node root) {
        if (root == null)
            return new double[]{0, 0};
        double[] left = findMaxAvgSubTree(root.left);
        double[] right = findMaxAvgSubTree(root.right);
        double sum = left[0] + right[0] + root.data;
        double count = left[1] + right[1] + 1;
        double avg = sum / count;
        max = Math.max(max, avg);
        return new double[]{sum, count};
    }
}
