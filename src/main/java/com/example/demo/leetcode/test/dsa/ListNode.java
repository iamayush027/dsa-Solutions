package com.example.demo.leetcode.test.dsa;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public void addNode(int value) {
        if (this.next == null) {
            this.next = new ListNode(value);

        } else {
            while (next.next != null) ;
            next.next = new ListNode(value);
        }
    }
}
