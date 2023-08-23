package com.example.demo.interview;


public class TestCode {
    public static void main(String[] args) {
        String str1="Hello";
        String str2="Hello";
        String str3=new String("world");
        String str4=new String("world");
        String str5="world";
        String str6=str3;
        System.out.println(str1==str2);
        System.out.println(str3==str4);
        System.out.println(str3==str5);
        System.out.println(str5==str6);
    }

}
