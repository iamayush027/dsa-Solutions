package com.example.demo.leetcode.test.dsa;

public class MiddleofLinkedList {
    public static void main(String[] args) {

        ListNode head= new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
//        head.next.next.next.next.next=new ListNode(6);

        System.out.println(middleNode(head).val);


    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while (fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
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
