package com.example.demo.leetcode.test.dsa;

import java.util.Arrays;

public class WiggleSort2 {
    public static void main(String[] args) {
        int[] nums = {1, 5, 1, 1, 6, 4};
        wiggleSort(nums);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }

    public static void wiggleSort(int[] nums) {
        int arr[] = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);
        int n = nums.length - 1;
        for (int i = 1; i < nums.length; i += 2) nums[i] = arr[n--];
        for (int i = 0; i < nums.length; i += 2) nums[i] = arr[n--];

    }
}
