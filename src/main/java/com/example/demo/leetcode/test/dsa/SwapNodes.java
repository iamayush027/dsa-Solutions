package com.example.demo.leetcode.test.dsa;

public class SwapNodes {
    public static void main(String[] args) {

    }

    public ListNode swapNodes(ListNode head, int k) {

        ListNode first;
        ListNode second;
        ListNode iterator = head;
        int count = 1;

        while (count++ < k) {
            iterator = iterator.next;
        }
        first = iterator;
        second = head;
        while (iterator.next != null) {
            iterator = iterator.next;
            second = second.next;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
