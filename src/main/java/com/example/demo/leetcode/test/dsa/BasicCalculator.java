package com.example.demo.leetcode.test.dsa;

import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        System.out.println(calculate("2+(2+4)-5"));
    }

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int number = 0, result = 0;
        int sign = 1;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                number = number * 10 + (int) (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result = result + sign * number + stack.pop() * stack.pop();
                sign = 1;
                number = 0;

            }
        }
        return number == 0 ? result : result + sign * number;
    }
}
