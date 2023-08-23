package com.example.demo.leetcode.test.dsa;

public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        int startingStation = canCompleteCircuit(gas, cost);

        System.out.println("Starting gas station index: " + startingStation);

    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas = 0;
        int currentGas = 0;
        int startStation = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i] - cost[i];
            if (currentGas < 0) {
                currentGas = gas[i] - cost[i];
                startStation = i;
            } else {
                currentGas += gas[i] - cost[i];
            }
        }
        return totalGas >= 0 ? startStation : -1;
    }
}
