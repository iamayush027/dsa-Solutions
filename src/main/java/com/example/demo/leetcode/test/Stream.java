package com.example.demo.leetcode.test;

import org.apache.logging.log4j.spi.CopyOnWrite;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Stream {
    public static void main(String[] args) {
        List<Integer> list= List.of(2,24,5,13,6,7,8,34,7,8,53,7,0,1,8,7,4);
        System.out.println(list.stream().reduce(Integer::sum));
        CopyOnWriteArrayList<Integer> newList=new CopyOnWriteArrayList<>(list);

    }
}
