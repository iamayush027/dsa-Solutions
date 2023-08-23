package com.example.demo.leetcode.test.dsa;

public class SortColor {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 1, 2, 0, 1};
        sortColors(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    public static void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        for (int i = 0; i <= r; ) {
            if (nums[i] == 0) {
                swap(nums, i++, l++);
            } else if (nums[i] == 1) {
                ++i;
            } else swap(nums, i, r--);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
