//package com.example.demo.leetcode.test.leetcode;
//
//import java.util.Arrays;
//
//public class SalesManTravelProblem {
//    static int[][] cost;
//    static int[][] dp = new int[4][1 << 4];
//    static int MAX=Integer.MAX_VALUE;
//
//    public static void main(String[] args) {
//       cost = new int[][]{
//               {0, 0, 0, 0, 0}, {0, 0, 10, 15, 20},
//               {0, 10, 0, 25, 25}, {0, 15, 25, 0, 30},
//               {0, 20, 25, 30, 0},
//       };
//        int ans = MAX;
//        for (int i = 1; i <= 4; i++)
//            // try to go from node 1 visiting all nodes in
//            // between to i then return from i taking the
//            // shortest route to 1
////            ans = Math.min(ans, solve(i, (1 << (4 + 1)) - 1)
////                    + cost[i][1]);
////        System.out.println(solve(0, (1 << 4) - 1, 4));
//    }
//
//    private static int solve(int i, int mask, int n) {
//        if (mask == ((1 << i) | 3))
//            return cost[1][i];
//        if (dp[i][mask] != 0)
//            return dp[i][mask];
//        int minValue = MAX;
//        for (int j = 1; j <= n; j++) {
//            if (((mask & (1 << j)) != 0) && j != i && j != 1)
//                minValue = Math.min(minValue, cost[j][i] + solve(j, mask ^ (1 << j), n));
//        }
//        dp[i][mask] = minValue;
//        return minValue;
//    }
//}
