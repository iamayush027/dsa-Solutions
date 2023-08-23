package com.example.demo.interview;

public class MissingNumber {

    public static int find(int[] nums) {
        int n = nums.length;
        int missingNumber = 0;
        for (int num : nums) {
            missingNumber ^= 1 << num;
        }
        for (int i = 1; i < n; i++) {
            if ((missingNumber & 1 << i) == 0)
                return i;
        }
        System.out.println("Missing Number Not found!");
        return 0;
    }


    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 3};
        System.out.println("Missing number: " + find(arr));
    }
}
