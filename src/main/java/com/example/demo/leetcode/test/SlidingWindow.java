package com.example.demo.leetcode.test;

import java.util.HashSet;
import java.util.Set;

public class SlidingWindow {
    public static int findMax(int[] arr) {

        int k = 2;
        int maxSum = 0;
        for (int i = 0; i < k; i++)
            maxSum += arr[i];
        int windowSum = maxSum;
        for (int i = k; i < arr.length; i++) {
            windowSum = windowSum + arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    public static int findMaxString(String str) {
        int left = 0, right = 0;
        Set<Character> stringSet = new HashSet<>();
        int max = Integer.MIN_VALUE;

        while (right < str.length()) {
            char c = str.charAt(right);
            if (stringSet.add(c)) {
                max = Math.max(max, right - left + 1);
                right++;
            } else {
                while (str.charAt(left) != c) {
                    stringSet.remove(str.charAt(left));
                    left++;
                }
                stringSet.remove(c);
                left++;
            }
        }
        return max;
    }

    public static boolean checkBinary(String str) {
        int left = 0, right = 2;
        int count = 0;
        Set<String> binarySet = new HashSet<>();
        while (right < str.length()) {
            if (binarySet.add(str.substring(left, right + 1))) {
                count++;

            }
            left++;
            right++;

        }
        System.out.println(binarySet);
        return count == 8;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3};
//        System.out.println(findMax(arr));
        System.out.println(findMaxString("abcabcbafg"));
      //  System.out.println(checkBinary("011001110101000"));
    }
}
