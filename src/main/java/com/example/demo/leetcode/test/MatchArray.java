package com.example.demo.leetcode.test;

public class MatchArray {
    public static void main(String[] args) {
        int[] arr1 = {123, 543};
        int[] arr2 = {321, 279};
        int counter = 0;
        for (int i = 0; i < arr1.length; i++) {
            String value1 = String.valueOf(arr1[i]);
            String value2 = String.valueOf(arr2[i]);
            for (int j = 0; j < value1.length(); j++) {
                int num1 = Integer.parseInt(Character.toString(value1.charAt(j)));
                int num2 = Integer.parseInt(Character.toString(value2.charAt(j)));
                counter += Math.abs(num1 - num2);

            }


        }

        System.out.println("Counter :" + counter);
    }
}
