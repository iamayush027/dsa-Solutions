package com.example.demo.leetcode.test.dsa;

public class CheckIfPairAreDivisible {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 10, 6, 7, 8, 9};
        System.out.println(canArrange(arr, 5));
    }

    public static boolean canArrange(int[] arr, int k) {
        int[] frequency = new int[k];
        for (int num : arr) {
            num %= k;
            if (num < 0) num += k;
            frequency[num]++;
        }
        if (frequency[0] % 2 != 0) return false;
        for (int i = 1; i <= k / 2; i++) {
            if (frequency[i] != frequency[k - i]) return false;
        }
        return true;
    }
}
