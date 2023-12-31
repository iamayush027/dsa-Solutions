package com.example.demo.leetcode.test.dsa;

import java.util.ArrayDeque;
import java.util.Deque;

public class HitCounter {
    Deque<Integer> deque;

    HitCounter() {
        deque = new ArrayDeque<>();
    }

    public static void main(String[] args) {
        HitCounter counter = new HitCounter();

// hit at timestamp 1.
        counter.hit(1);

// hit at timestamp 2.
        counter.hit(2);

// hit at timestamp 3.
        counter.hit(3);

// get hits at timestamp 4, should return 3.
        counter.getHits(4);

// hit at timestamp 300.
        counter.hit(300);

// get hits at timestamp 300, should return 4.
        counter.getHits(300);

// get hits at timestamp 301, should return 3.
        counter.getHits(301);
    }

    public void hit(int timestamp) {
        deque.add(timestamp);

    }

    public int getHits(int timestamp) {

        while (!deque.isEmpty() && timestamp - deque.peek() >= 300) {
            deque.poll();
        }
        return deque.size();
    }
}
