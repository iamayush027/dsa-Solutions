package com.example.demo.leetcode.test.dsa;

public class TwoArraySum {
    public static void main(String[] args) {
        for (int n : twoSum(new int[]{2, 7, 11, 15}, 9)
        ) {
            System.out.print(n + " ");
        }
    }

    public static int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        while (start <= end) {
            int num = numbers[start] + numbers[end];
            if (num > target) end--;
            else if (num < target) start++;
            else break;
        }
        return new int[]{start+1, end+1};

    }
}
