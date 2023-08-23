package com.example.demo.interview;

import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class Test {
    Test(){
        System.out.println("1");
    }

    public static void main(String[] args) {
    boolean bol= Boolean.parseBoolean("trurr");
        System.out.println(bol);

    }
}

class InvalidInput extends Exception{
    long ser;
}
 class MyThread extends Thread{
    MyThread()
    {
        System.out.println("MY THREAD");
    }
     @Override
     public void run() {
         System.out.println("run");
     }
     public void run(String s) {
         System.out.println("run with s");
     }
 }