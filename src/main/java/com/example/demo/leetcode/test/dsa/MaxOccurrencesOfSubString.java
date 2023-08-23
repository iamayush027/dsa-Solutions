package com.example.demo.leetcode.test.dsa;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MaxOccurrencesOfSubString {
    public static void main(String[] args) {
        System.out.println(maxFreq("aababcaab",2,3,4));
    }

    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> occurrences = new HashMap<>();
        int[] countLetters = new int[26];
        int left = 0, right = 0, uniqueCount = 0;

        while (right < s.length()) {
            char c = s.charAt(right++);
            countLetters[c - 'a']++;
            if (countLetters[c - 'a'] == 1)
                uniqueCount++;

            while ((right - left) >= minSize && (right - left) <= maxSize) {
                if (uniqueCount <= maxLetters) {
                    String sub = s.substring(left, right);
                    occurrences.put(sub, occurrences.getOrDefault(sub, 0) + 1);
                }
                char l = s.charAt(left++);
                countLetters[l - 'a']--;
                if (countLetters[l - 'a'] == 0) {
                    uniqueCount--;
                }
            }
        }
        return occurrences.entrySet().stream().map(Map.Entry::getValue).max(Comparator.naturalOrder()).orElse(0);

    }
}
