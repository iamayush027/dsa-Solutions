package com.example.demo.leetcode.test.dsa;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }

    public static String decodeString(String s) {
        Stack<Integer> numStack = new Stack<Integer>();
        Stack<StringBuffer> stringBuilderStack = new Stack<StringBuffer>();
        int num = 0;
        StringBuffer str = new StringBuffer();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (Character.isLetter(c)) {
                str.append(c);
            } else if (c == '[') {
                numStack.push(num);
                num = 0;
                stringBuilderStack.push(str);
                str = new StringBuffer();
            } else {
                StringBuffer temp = str;
                str = stringBuilderStack.pop();
                int number = numStack.pop();
                while (number-- > 0) str.append(temp);
            }

        }
        return str.toString();


    }
}
