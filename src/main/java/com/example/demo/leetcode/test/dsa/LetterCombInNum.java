package com.example.demo.leetcode.test.dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombInNum {
    static List<String> res = new ArrayList<>();
    static Map<Character, String> stringMap = new HashMap<>();

    public static void main(String[] args) {
        for (String s : letterCombinations("23")) {
            System.out.println(s);
        }
    }

    private static void solve(String baseString, int index, String digits, int length) {
        if (baseString.length() == length) {
            res.add(baseString.toString());
            return;
        }
        char c = digits.charAt(index);
        String string = stringMap.get(c);
        for (int i = 0; i < string.length(); i++) {
            solve(baseString + string.charAt(i), index + 1, digits, length);
        }
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;
        stringMap.put('2', "abc");
        stringMap.put('3', "def");
        stringMap.put('4', "ghi");
        stringMap.put('5', "jkl");
        stringMap.put('6', "mno");
        stringMap.put('7', "pqrs");
        stringMap.put('8', "tuv");
        stringMap.put('9', "wxyz");
        solve("", 0, digits, digits.length());
        return res;

    }

}
