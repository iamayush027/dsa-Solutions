package com.example.demo.leetcode.test.dsa;

import java.util.List;

public class ReverseWord {
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    public static String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> stringList = List.of(s.split(" "));
        for (String str : stringList) {
            int start = 0;
            int end = str.length() - 1;
            char[] chars = str.toCharArray();
            while (start < end) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
            stringBuilder.append(new String(chars)).append(" ");
        }
        return stringBuilder.toString().trim();
    }
}
