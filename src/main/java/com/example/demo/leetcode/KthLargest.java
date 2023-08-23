package com.example.demo.leetcode;

import java.util.PriorityQueue;

public class KthLargest {
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int n : nums) add(n);
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 6};
        KthLargest k = new KthLargest(3, arr);
        System.out.println(k.add(7));

    }

    public int add(int val) {
        queue.offer(val);
        if (queue.size() > k) queue.poll();
        return queue.peek();
    }
}
