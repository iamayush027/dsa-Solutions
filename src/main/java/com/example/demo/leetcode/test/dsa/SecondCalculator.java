package com.example.demo.leetcode.test.dsa;

import java.util.Stack;

public class SecondCalculator {
    public static void main(String[] args) {
        System.out.println(calculate("2+3*5+4+5*0"));
    }

    public static int calculate(String s) {
        int number = 0;
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        char operator = '+';
        for (char c : s.toCharArray()) {

            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            }
            if (!Character.isDigit(c) && c != ' ' || index == s.length() - 1) {
                switch (operator) {
                    case '+':
                        stack.push(number);
                        break;
                    case '-':
                        stack.push(-1 * number);
                        break;
                    case '*':
                        stack.push(stack.pop() * number);
                        break;
                    case '/':
                        stack.push(stack.pop() / number);
                        break;
                    default:
                        new Exception("Invalid Expression");
                }
                operator = c;
                number = 0;
            }
            index++;
        }
        int sum = number;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
