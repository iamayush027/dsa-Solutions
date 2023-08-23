package com.example.demo.leetcode.test.dsa;

public class SwapNum {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode head2 = new ListNode(2);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(4);
       ListNode result= mergeList(head,head2);
//        head = swapPairs(head);
//        head = removeNthFromEnd(head, 3);
        printList(result);
//        int value = reverseLinkedList(head);
//        System.out.println("" + value);

    }

    private static ListNode mergeList(ListNode head1, ListNode head2) {
        ListNode firstListPointer = head1, secondListPointer = head2;
        while (firstListPointer.next != null || secondListPointer.next != null) {
            while (firstListPointer.next != null && firstListPointer.val < secondListPointer.val) {
                firstListPointer = firstListPointer.next;
            }
            ListNode firstNextNode = head1.next;
            ListNode secondNextNode = head2.next;
            firstListPointer.next = secondListPointer;
            secondListPointer.next = firstNextNode;
            secondListPointer = secondNextNode;

        }
        return head1;
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {

        ListNode result = new ListNode();
        result.next = head;
        ListNode current = result;
        while (current.next != null && current.next.next != null) {
            System.out.println("*");
            ListNode t1 = current.next;
            ListNode t2 = current.next.next;
            current.next = t2;
            t1.next = t2.next;
            t2.next = t1;
            current = current.next.next;
        }
        return result.next;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        for (int i = 0; i < n; i++) fast = fast.next;
        if (fast == null) return head.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static int reverseLinkedList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int maxValue = Integer.MIN_VALUE;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        while (slow != null) {
            ListNode nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }
        while (prev != null) {
            maxValue = Math.max(maxValue, (prev.val + head.val));
            prev = prev.next;
            head = head.next;

        }
        return maxValue;

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
