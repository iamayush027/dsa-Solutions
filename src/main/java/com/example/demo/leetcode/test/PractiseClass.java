package com.example.demo.leetcode.test;

public class PractiseClass {
    public static void main(String[] args) {
        int num1=50;
        int num2=2;
        int count=0;
        while(num1!=num2)
        {
            count++;
            if(num1>num2)
            {
                num1-=num2;
            }
            else {
                num2-=num1;
            }
        }

        System.out.println(num1);
        System.out.println(num2);
        System.out.println(count);
    }
}
