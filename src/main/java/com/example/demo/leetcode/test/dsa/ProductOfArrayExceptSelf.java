package com.example.demo.leetcode.test.dsa;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        int[] result = productExceptSelf(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;

        int[] prefix = new int[length];
        int[] suffix = new int[length];
        int[] result = new int[length];
        prefix[0] = 1;
        suffix[length - 1] = 1;
        for (int i = 1; i < length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        for (int i = length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < length; i++) {
            result[i] = prefix[i] * suffix[i];
        }
        return result;
    }
}
