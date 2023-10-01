package com.example.demo.memory;

public class StringThread implements Runnable{

    @Override
    public void run() {
        String str=new String("Hello World String!!");
        for (int i = 0; i< Integer.MAX_VALUE; i++);
        str=str.concat("world");
    }




}
