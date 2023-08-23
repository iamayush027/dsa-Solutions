package com.example.demo.leetcode.test.dsa;

public class RemoveDuplicateFromList {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(1);
        root.next.next = new ListNode(1);
        root.next.next.next = new ListNode(2);
        root.next.next.next.next = new ListNode(3);
//        root.next.next.next.next.next = new ListNode(4);
//        root.next.next.next.next.next.next = new ListNode(5);

        ListNode result = deleteDuplicates(root);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public static ListNode deleteOneDuplicates(ListNode head) {
        ListNode prev = head;
        ListNode root = head.next;
        while (root != null) {
            if (root.val == prev.val) {
                if (root.next == null) {
                    prev.next = null;
                } else
                    prev.next = root.next;
            }
            prev = root;
            root = root.next;
        }
        return head;

    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                while (current.next != null && current.val == current.next.val) current = current.next;
                if (prev == null)
                    head = current.next;
                else {
                    prev.next = current.next;
                }
                current = current.next;
            } else {
                prev = current;
                current = current.next;
            }
        }
        return head;

    }

    public static class ListNode {
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
