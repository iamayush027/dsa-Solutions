package com.example.demo.leetcode.test.dsa;

public class RecoverBST {
    static TreeNode prev = null;
    static TreeNode first = null;
    static TreeNode second = null;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        recoverTree(root);
        System.out.println(root.val);

    }

    public static void recoverTree(TreeNode root) {
        if (root == null) return;
        inOrder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        if (prev != null && root.val < prev.val) {
            if (first == null) first = prev;
            second = root;
        }
        prev = root;
        inOrder(root.right);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
