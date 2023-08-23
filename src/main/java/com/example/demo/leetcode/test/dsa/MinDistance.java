package com.example.demo.leetcode.test.dsa;

public class MinDistance {
    public static void main(String[] args) {
        System.out.println(minDistance("horse","ros"));
    }
    {
        System.out.println("WOD");
    }
    MinDistance()
    {
        System.out.println("HI");
    }
    public void MinDistance()
    {
        System.out.println("HELLO");
    }
    public static int minDistance(String word1, String word2) {
        MinDistance minDistance=new MinDistance() ;
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int i = 0; i <= n; i++) dp[0][i] = i;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }
        }
        return dp[m][n];
    }
}
