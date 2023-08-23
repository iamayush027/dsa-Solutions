package com.example.demo.leetcode.test.dsa;

public class ClosestInBST {
    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        ClosestInBST solution = new ClosestInBST();
        double target = 3.714286;
        int closestValue = solution.closestValue(root, target);

        System.out.println("Closest value to " + target + " in the BST is: " + closestValue);
    }

    private int closestValue(TreeNode root, double target) {
        int closest = root.val;
        while (root != null) {
            closest = Math.abs(root.val - target) < Math.abs(closest - target) ? root.val : closest;
            if (target < root.val) root = root.left;
            else root = root.right;
        }
        return closest;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
