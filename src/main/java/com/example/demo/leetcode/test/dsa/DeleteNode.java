package com.example.demo.leetcode.test.dsa;

import java.util.Optional;

public class DeleteNode {
    public static void main(String[] args) {
        Optional<String> optionalString = null;
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);

        ListNode temp=head;
        while (temp!=null)
        {
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
        deleteNode(head.next);
        System.out.println("");
        while (head!=null)
        {
            System.out.print(head.val+" ");
            head=head.next;
        }
    }

    public static void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;

    }
}

