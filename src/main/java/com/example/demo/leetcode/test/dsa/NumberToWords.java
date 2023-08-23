package com.example.demo.leetcode.test.dsa;


public class NumberToWords {
    public static void main(String[] args) {
        System.out.println(numberToWords(999999999));

    }

    public static String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        return helper(num);
    }

    private static String helper(int num) {
        final String[] belowTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

        StringBuilder stringBuilder = new StringBuilder();
        if (num < 20) {
            stringBuilder.append(belowTwenty[num]);
        } else if (num < 100) {
            stringBuilder.append(tens[num / 10]).append(belowTwenty[num % 10]);
        } else if (num < 1000) {
            stringBuilder.append(helper(num / 100)).append(" Hundred ").append(helper(num % 100));
        } else if (num < 1000000) {
            stringBuilder.append(helper(num / 1000)).append(" thousand ").append(helper(num % 1000));
        } else if (num < 1000000000) {
            stringBuilder.append(helper(num / 1000000)).append(" Million ").append(helper(num % 1000000));
        } else {
            stringBuilder.append(helper(num / 1000000000)).append(" Million ").append(helper(num % 1000000000));
        }
        return stringBuilder.toString().trim();
    }

}
