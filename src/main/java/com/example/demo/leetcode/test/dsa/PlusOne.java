package com.example.demo.leetcode.test.dsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {9, 9, 9, 9};
        int value = 1;
        int carry = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = digits.length - 1; i >= 0; i--) {
            value += digits[i];

            carry = value / 10;
            value = value % 10;
            list.add(value);
            value = carry;

        }
        if (value > 0) {
            list.add(value);
        }
            Collections.reverse(list);
            for (int n : list) {
                System.out.print(n + " ");

            }

    }


}
