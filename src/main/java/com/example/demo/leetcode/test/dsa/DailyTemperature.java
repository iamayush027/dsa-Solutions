package com.example.demo.leetcode.test.dsa;

import java.util.Stack;

public class DailyTemperature {
    public static void main(String[] args) {
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        Stack<Pair> pairStack = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!pairStack.isEmpty() && arr[i] > pairStack.peek().value) {
                ans[pairStack.peek().index] = i - pairStack.peek().index;
                pairStack.pop();
            }
            pairStack.push(new Pair(arr[i], i));
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(ans[i]);
        }
    }

    static class Pair {
        int index;
        int value;

        public Pair(int value, int index) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
