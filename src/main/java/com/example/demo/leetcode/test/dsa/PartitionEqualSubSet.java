package com.example.demo.leetcode.test.dsa;

public class PartitionEqualSubSet {
    static Boolean[][] dp;

    public static void main(String[] args) {

        int[] nums = {2, 2, 1, 1};
        System.out.println(canPartition(nums));

    }

    private static boolean check(int[] nums, int target, int left, int index, Boolean[][] dp) {

        if (index == nums.length) {
            return left == target;
        }
        if (left > target) return false;
        if (dp[index][left] != null) {
            return dp[index][left];
        }
        boolean check = check(nums, target, left + nums[index], index + 1, dp) || check(nums, target, left, index + 1, dp);
        dp[index][left] = check;
        return check;
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % 2 != 0) return false;
        dp = new Boolean[nums.length][(sum / 2) + 1];
        return check(nums, sum / 2, 0, 0, dp);
    }
}
