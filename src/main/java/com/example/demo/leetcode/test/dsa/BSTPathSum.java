package com.example.demo.leetcode.test.dsa;

public class BSTPathSum {
    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root, 0, targetSum);
    }

    private boolean hasPathSum(TreeNode root, int sum, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            if (sum + root.val == targetSum)
                return true;
        }
        return hasPathSum(root.left, sum + root.val, targetSum) || hasPathSum(root.right, sum + root.val, targetSum);


    }

    public class TreeNode {
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
