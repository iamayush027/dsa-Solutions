package com.example.demo.leetcode.test.dsa;

public class LemonadeChange {
    public static void main(String[] args) {
        int[] arr = {5, 5, 10, 10, 5, 20, 5, 10, 5, 5};
        System.out.println(lemonadeChange(arr));
    }

    public static boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int num : bills) {
            if (num == 5) {
                five++;
            } else if (num == 10) {
                if (five < 1) return false;
                five--;
                ten++;
            } else {
                if (ten >= 1 && five >= 1) {
                    ten--;
                    five -= 1;
                } else if (five >= 3) {
                    five -= 3;
                } else return false;
            }
        }
        return true;
    }
}
