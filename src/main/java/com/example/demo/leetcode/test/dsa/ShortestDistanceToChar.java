package com.example.demo.leetcode.test.dsa;

public class ShortestDistanceToChar {
    public static void main(String[] args) {

    }

    public int[] shortestToChar(String s, char c) {
        int[] arr = new int[s.length()];

        int prev = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                prev = 0;
                arr[i] = 0;
            } else {
                arr[i] = ++prev;
            }
        }

        prev = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                prev = 0;
                arr[i] = 0;
            } else {
                arr[i] = Math.min(arr[i], ++prev);
            }
        }
        return arr;
    }
}
