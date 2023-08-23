package com.example.demo.leetcode.test.dsa;

public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(1000));
    }

    public static String intToRoman(int num) {
        String[] ones = {"", "I", "II", "III", "IIV", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XXC", "XC", "C"};
        String[] ths = {"", "C", "CC", "CCC", "DC", "C", "CD", "CDD", "CDDD", "DDM", "DM", "M"};
        String[] mm = {"", "M", "MM", "MMM"};
        return mm[num / 1000] + ths[(num % 1000) / 100] + tens[(num % 100) / 10] + ones[(num % 10)];
    }
}
