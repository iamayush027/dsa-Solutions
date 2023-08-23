package com.example.demo.leetcode.test.dsa;

public class ReverseNodeInKGroup {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        printList(head);
        System.out.println();
        System.out.println("******REVERSED*********");
        head = reverseKGroup(head, 3);
        printList(head);
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head==null)return null;
        if(head.next==null) return head;

        ListNode prev = null;
        int count = 0;
        ListNode temp = null;
        ListNode curr=head;
        while (curr != null && count < k) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            count++;
        }
        if (temp != null && size(temp) >= k) {
            head.next = reverseKGroup(temp, k);
        } else {
            head.next = temp;
        }
        return prev;

    }

    public static int size(ListNode head) {
        if (head == null) {
            return 0;
        }
        if (head.next == null) {
            return 1;
        }
        int p = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            p++;
        }
        return p;
    }
}
