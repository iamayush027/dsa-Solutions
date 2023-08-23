package com.example.demo.leetcode.test.dsa;

public class CheckPalindromeWithOneDeletion {
    public static void main(String[] args) {
        validPalindrome("sd");
    }

    public static boolean validPalindrome(String s) {
        return check(s, false, 0, s.length() - 1);

    }

    private static boolean check(String s, boolean isDeleted, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                if (isDeleted) {
                    return false;
                }
                return check(s, true, i + 1, j) || check(s, true, i, j - 1);
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}
