package com.example.demo.leetcode.test.dsa;

import java.util.Optional;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        for (int i : maxSlidingWindow(arr, k)) {
            System.out.print(i + " ");
        }

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0;
        int right =  k - 1;
        int[] maxArray=new int[nums.length];
        while (right < nums.length) {
            int localMax = Integer.MIN_VALUE;
            for (int i = left; i <= right; i++) {
               localMax= Math.max(localMax, nums[i]);
            }
            maxArray[left]=localMax;
            left++;
            right++;
        }
        return maxArray;
    }
}
