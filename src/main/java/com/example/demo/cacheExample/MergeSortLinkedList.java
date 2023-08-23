package com.example.demo.cacheExample;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class MergeSortLinkedList {

    // Merge Sort function for LinkedList
    public static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMiddle(head);
        ListNode nextOfMid = mid.next;
        mid.next = null;

        ListNode left = mergeSort(head);
        ListNode right = mergeSort(nextOfMid);

        return merge(left, right);
    }

    // Merge two sorted linked lists
    public static ListNode merge(ListNode left, ListNode right) {
        ListNode sortedList = new ListNode(0);
        ListNode current = sortedList;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current=current.next;
        }
        if(left!=null) current.next=left;
        if(right!=null) current.next=right;
        return sortedList.next;
    }

    // Helper function to find the middle node of the linked list
    public static ListNode getMiddle(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Utility function to print the linked list
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Driver method to test the example
    public static void main(String[] args) {
        ListNode head = new ListNode(64);
        head.next = new ListNode(34);
        head.next.next = new ListNode(25);
        head.next.next.next = new ListNode(12);
        head.next.next.next.next = new ListNode(22);
        head.next.next.next.next.next = new ListNode(11);
        head.next.next.next.next.next.next = new ListNode(90);

        System.out.println("Original List:");
        printList(head);

        ListNode sorted = mergeSort(head);

        System.out.println("Sorted List:");
        printList(sorted);
    }
}
