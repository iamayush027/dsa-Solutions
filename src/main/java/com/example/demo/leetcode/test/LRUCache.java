package com.example.demo.leetcode.test;// Java program to implement LRU cache
// using LinkedHashSet

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {

    Map<Integer, Integer> cache;
    int capacity;

    public LRUCache(int capacity) {
        this.cache = new LinkedHashMap<Integer, Integer>();
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        LRUCache ca = new LRUCache(2);
        ca.get(2);
        ca.put(2, 6);
        ca.get(1);
        ca.display();
        System.out.println("");
        ca.put(1, 5);
        ca.put(1, 2);
        ca.display();
        System.out.println("");
        ca.get(1);
        ca.get(2);
        ca.display();
    }

    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;
        int value = cache.get(key);
        cache.remove(key);
        cache.put(key, value);
        return value;
    }

    public void display() {
        cache.entrySet().forEach(integerIntegerEntry -> {
            System.out.println("[" + integerIntegerEntry.getKey() + " , " + integerIntegerEntry.getValue() + "]");
        });

    }

    public void put(int key, int value) {
        if (cache.size() == this.capacity) {
            if (cache.containsKey(key)) {
                cache.remove(key);
                cache.put(key, value);
            }
            cache.remove(cache.keySet().stream().findFirst().get());
        }

        cache.put(key, value);

    }
}
