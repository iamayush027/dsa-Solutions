package com.example.demo.leetcode.test.dsa;

public class HouseRobber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        System.out.println(rob(arr));
    }


    public static int rob(int[] nums) {
        int prev1 = 0;
        int prev2 = 0;
        for (int num : nums) {
            int value = Math.max(prev1, prev2 + num);
            prev2=prev1;
            prev1=value;

        }
        return prev1;
    }

}
