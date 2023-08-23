package com.example.demo.leetcode.test.dsa;

public class LongestPalindrome {
    static int maxLen = 0;
    static int lo = 0;

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            expandPalindrome(s, i, i);
            expandPalindrome(s, i, i + 1);
        }
        return s.substring(lo, lo + maxLen);
    }

    private static void expandPalindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (maxLen < j - i - 1) {

            maxLen = j - i - 1;
            lo = i + 1;
        }
    }
}
