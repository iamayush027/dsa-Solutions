package com.example.demo.leetcode.test.dsa;

import java.util.HashMap;
import java.util.Map;

public class DebtSettlement {

    public static void main(String[] args) {
        int[][] transactions = {{0, 1, 10}, {2, 0, 5}};
        DebtSettlement debtSettlement = new DebtSettlement();
        int minTransactions = debtSettlement.minTransfers(transactions);
        System.out.println("Minimum number of transactions required: " + minTransactions);
    }

    public int minTransfers(int[][] transactions) {
        // Create a hashmap to store each person's balance
        Map<Integer, Integer> balances = new HashMap<>();

        // Calculate each person's balance based on the transactions
        for (int[] transaction : transactions) {
            int person1 = transaction[0];
            int person2 = transaction[1];
            int amount = transaction[2];

            balances.put(person1, balances.getOrDefault(person1, 0) - amount);
            balances.put(person2, balances.getOrDefault(person2, 0) + amount);
        }

        // Convert the hashmap values to an array for easier manipulation
        int[] debts = balances.entrySet().stream().mapToInt(Map.Entry::getValue).toArray();
        // Find the minimum number of transactions required using backtracking
        return settleDebts(0, debts);
    }

    private int settleDebts(int start, int[] debts) {

        int n = debts.length;

        while (start < n && debts[start] == 0)
            start++;
        if (start == n) return 0;
        int minNumberOfTransaction = Integer.MAX_VALUE;
        for (int i = start + 1; i < n; i++) {
            if (debts[start] * debts[i] < 0) {
                debts[i] += debts[start];
                minNumberOfTransaction = Math.min(minNumberOfTransaction, 1 + settleDebts(start + 1, debts));
                debts[i] -= debts[start];
            }
        }
        return minNumberOfTransaction;

    }
}

