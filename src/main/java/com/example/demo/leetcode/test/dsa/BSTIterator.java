package com.example.demo.leetcode.test.dsa;

import java.util.ArrayList;
import java.util.List;

class BSTIterator {
    static List<Integer> list;
    static int next = 0;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        dfs(root);
    }

    private static void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);

    }

    public static int next() {
        return list.get(next++);
    }

    public static boolean hasNext() {
        return list.size() > next();
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
