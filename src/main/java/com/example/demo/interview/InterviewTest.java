package com.example.demo.interview;

import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

import java.util.*;

public class InterviewTest {
    public static void main(String[] args) {
     User user=new User();

    }
    public void m1()
    {
        System.out.println("M!");
    }
}

class User{
    String name;
     int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}