package com.example.demo.leetcode.test.dsa;

import java.util.ArrayList;
import java.util.HashMap;

public class MaxFreqStack {
    HashMap<Integer, Integer> freqMap;
    int maxFreq;
    ArrayList<ArrayList<Integer>> freqStack;

    public MaxFreqStack() {
        freqMap = new HashMap<>();
        freqStack = new ArrayList<>();
        freqStack.add(new ArrayList<>());
        maxFreq = 0;
    }

    public static void main(String[] args) {
        MaxFreqStack freqStack = new MaxFreqStack();
        freqStack.push(5); // The stack is [5]
        freqStack.push(7); // The stack is [5,7]
        freqStack.push(5); // The stack is [5,7,5]
        freqStack.push(7); // The stack is [5,7,5,7]
        freqStack.push(4); // The stack is [5,7,5,7,4]
        freqStack.push(5); // The stack is [5,7,5,7,4,5]
        System.out.println(freqStack.pop());   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
        System.out.println(freqStack.pop());   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
        System.out.println(freqStack.pop());   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
        System.out.println(freqStack.pop());   // return 4, as 4, 5 and 7 is th ve most frequent, but 4 is closest to the top. The stack becomes [5,7].
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
    }


    public void push(int val) {
        int freq = freqMap.getOrDefault(val, 0) + 1;
        freqMap.put(val, freq);
        maxFreq = Math.max(maxFreq, freq);
        if (freq >= freqStack.size()) freqStack.add(new ArrayList<>());
        freqStack.get(freq).add(val);
    }

    public int pop() {
        ArrayList<Integer> list = freqStack.get(maxFreq);
        int value = list.remove(list.size() - 1);
        if (list.isEmpty()) {
            maxFreq--;
        }
        freqMap.put(value, freqMap.get(value) - 1);
        return value;
    }
}
