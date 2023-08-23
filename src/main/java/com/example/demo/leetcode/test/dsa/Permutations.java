package com.example.demo.leetcode.test.dsa;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = permute(nums);

        // Print the permutations
        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, tempList, result, used);
        return result;
    }

    private static void backtrack(int[] nums, List<Integer> tempList, List<List<Integer>> result, boolean[] used) {

        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    tempList.add(nums[i]);
                    used[i] = true;
                    backtrack(nums, tempList, result, used);
                    used[i] = false;
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
}
