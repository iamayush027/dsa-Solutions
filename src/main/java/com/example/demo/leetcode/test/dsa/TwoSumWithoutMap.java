package com.example.demo.leetcode.test.dsa;

public class TwoSumWithoutMap {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int target = 9;
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum == target) {
                break;
            }
            if (target < sum) {
                end--;
            } else {
                start++;
            }
        }
        if (start > end) {
            System.out.println("Not found");
        } else {
            System.out.println(start + " " + end);
        }

    }
}
