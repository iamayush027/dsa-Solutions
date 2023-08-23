package com.example.demo.leetcode.test.dsa;

public class BitMasking {
    public static void main(String[] args) {
        int subset = 15;
        display(subset, 10);
        subset = remove(subset, 2);
        display(subset, 10);
        subset = add(subset, 5);
        display(subset, 10);
    }

    private static int remove(int subset, int numberToRemove) {
        return (subset ^ (1 << (numberToRemove - 1)));

    }

    private static int add(int subset, int numberToAdd) {
        return (subset ^ (1 << (numberToAdd - 1)));

    }

    private static void display(int subset, int range) {
        for (int bit = 0; bit < range; bit++) {
            if ((int) (subset & (1 << bit)) > 0)
                System.out.print(bit + 1 + " ");
        }
        System.out.println("");
    }

}
