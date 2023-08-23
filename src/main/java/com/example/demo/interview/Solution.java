package com.example.demo.interview;

class Solution {
    public static void main(String[] args) {
        String str = "12345";
        System.out.println(nearestPalindromic(str));
    }

    public static String nearestPalindromic(String num) {
        long originalNumber = Long.parseLong(num);
        long smallerPalindrome = previousPalindrome(String.valueOf(originalNumber - 1).toCharArray());
        long largerPalindrome = nextPalindrome(String.valueOf(originalNumber + 1).toCharArray());
        System.out.println(largerPalindrome);
        System.out.println(smallerPalindrome);
        return String.valueOf((Math.abs(smallerPalindrome - originalNumber) > largerPalindrome - originalNumber) ? largerPalindrome : smallerPalindrome);
    }

    private static long nextPalindrome(char[] chars) {

        for (int i = 0; i < chars.length / 2; i++) {
            while (chars[i] != chars[chars.length - 1 - i]) {
                increment(chars, chars.length - 1 - i);
            }
        }
        return Long.parseLong(new String(chars));
    }

    private static void increment(char[] chars, int i) {
        while (chars[i] == '9') chars[i--] = '0';
        chars[i]++;

    }

    private static long previousPalindrome(char[] chars) {
        for (int i = 0; i < chars.length / 2; i++) {
            while (chars[i] != chars[chars.length - 1 - i]) {
                decrement(chars, chars.length - 1 - i);
                if (chars[0] == '0') return Long.parseLong(new String(chars));
            }
        }
        return Long.parseLong(new String(chars));
    }

    private static void decrement(char[] chars, int i) {
        while (chars[i] == '0') chars[i--] = '9';
        chars[i]--;
    }


}
