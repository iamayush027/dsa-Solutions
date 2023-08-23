package com.example.demo.leetcode.test.dsa;

public class SquareArray {
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        int left = 0;
        int right = nums.length - 1;
        int arr[] = new int[nums.length];
        for (int i = nums.length-1; i >=0; i--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                arr[i] = nums[left] * nums[left];
                left++;
            } else {
                arr[i] = nums[right] * nums[right];
                right--;
            }
        }
        for(int i=0;i< arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}
