package com.example.demo.leetcode.test.dsa;

import java.util.Arrays;

public class PeopleAndJobBitmask {
    static int[][] cost = new int[4][4];
    static int[][] dp = new int[4][1 << 4];

    public static void main(String[] args) {
        cost = new int[][]{{9, 2, 7, 8}, {6, 4, 3, 7}, {5, 8, 1, 8}, {7, 6, 9, 4}};
        for (int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(System.currentTimeMillis());
        int value = solve(0, (1 << 4) - 1, 4);
        System.out.println(value);
        System.out.println(System.currentTimeMillis());

    }

    private static int solve(int i, int mask, int n) {
        int minValue = Integer.MAX_VALUE;
        if (i == n) return 0;
        if (dp[i][mask] != -1) {
            return dp[i][mask];
        }
        for (int j = 0; j < cost.length; j++) {
            if ((mask & (1 << j)) > 0) {
                minValue = Math.min(minValue, cost[i][j] + solve(i + 1, mask ^ (1 << j), n));
            }
        }
        dp[i][mask] = minValue;
        return minValue;
    }
}
