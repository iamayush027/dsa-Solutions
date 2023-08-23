package com.example.demo.leetcode.test.dsa;

import java.util.HashMap;
import java.util.Map;

public class KDiffPair {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        System.out.println(findPairs(arr, 0));
    }

    public static int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int n : nums) {
            if (k > 0 && map.containsKey(n + k) || map.containsKey(n) && k == 0 && map.get(n) > 1) count++;
            else map.put(n, map.getOrDefault(n, 0) + 1);
        }
        return count;
    }

    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];
        int i = nums.length;
        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            if (leftSquare > rightSquare) {
                result[i] = leftSquare;
                left++;
            } else {
                result[i] = rightSquare;
                right--;
            }
            i--;
        }
        return result;
    }
}
