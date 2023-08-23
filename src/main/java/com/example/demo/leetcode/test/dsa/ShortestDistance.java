package com.example.demo.leetcode.test.dsa;

public class ShortestDistance {
    public static void main(String[] args) {
        String[] arr = {"A", "B", "C", "D", "E", "F", "G"};
        String str1 = "B";
        int str1Index = -1;
        int str2Index = -1;
        String str2 = "F";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == str1) {
                str1Index = i;
            }
            if (arr[i] == str2) {
                str2Index = i;
            }
        }


        System.out.println(Math.abs(str2Index-str1Index));

    }
}
