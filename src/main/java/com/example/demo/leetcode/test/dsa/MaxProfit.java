package com.example.demo.leetcode.test.dsa;

public class MaxProfit {

    public static void main(String[] args) {


        int[] prices = {7, 1, 2, 5, 3, 8};
        int minValue = Integer.MAX_VALUE;
        int dailyProfit = 0;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            minValue=Math.min(prices[i], minValue);
            maxProfit = Math.max(maxProfit, prices[i] - minValue);
        }
        System.out.println("Max profit: " + maxProfit);
    }
}
