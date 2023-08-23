package com.example.demo.leetcode.test.dsa;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins=new int[]{2,3,5};
        System.out.println(coinChange(coins,7));
    }
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];

    }
}
