package com.example.demo.leetcode.test.dsa;

import com.example.demo.leetcode.test.BinaryTree;

public class IsValidBST {
    static long minValue = Long.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        System.out.println(isValidBST(root));
    }
    public static boolean isValidBST(TreeNode root) {
return isValidBST(root,null,null);
    }

    public static boolean isValidBST(TreeNode root, Integer minValue, Integer maxValue) {

        if (root == null) return true;
        if ((minValue != null && root.val <= minValue) || (maxValue != null && root.val >= maxValue)) {
            return false;
        }
        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);

    }

   static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }


}
