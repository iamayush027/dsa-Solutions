package com.example.demo.leetcode.test.dsa;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubSequence {
    public static void main(String[] args) {

        int[] nums = {100, 4, 200, 1, 3, 2};
        int longestLength = longestConsecutive(nums);

        System.out.println("The length of the longest consecutive sequence is: " + longestLength);

    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longestStreak = 0;
        for (int num : nums) set.add(num);
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                longestStreak = Math.max(longestStreak, currentStreak);

            }
        }
        return longestStreak;
    }
}
