package com.example.demo.leetcode.test.dsa;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        Arrays.sort(nums);
        Set<List<Integer>> list = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    list.add(List.of(nums[i], nums[j], nums[k]));
                }
                if (sum < target) j++;
                else k--;
            }
        }
        return list.stream().toList();
    }
}
