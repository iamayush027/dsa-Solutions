package com.example.demo.leetcode.test.dsa;

public class AddLinkList {
    public static void main(String[] args) {
        ListNode head = new ListNode(9);
        head.next = new ListNode(9);
        head.next.next = new ListNode(9);
        head.next.next.next = new ListNode(9);
        head.next.next.next.next = new ListNode(9);
//        System.out.println(middleNode(head).val);
//        printList(reverseList(head));

//        head = reverseList(head);

        ListNode head2 = new ListNode(1);

//        head2 = reverseList(head2);

        ListNode result = addTwoNumbers(head, head2);
        printList(result);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int sum = 0;
        ListNode finalList = new ListNode(0);
        ListNode result = finalList;
        while (l1 != null || l2 != null) {
            sum += carry;
            if (l1!= null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            sum = sum % 10;
            finalList.next = new ListNode(sum);
            finalList=finalList.next;
            sum=0;

        }
        if(carry>0)
        {
            finalList.next=new ListNode(carry);
        }
        return result.next;
    }
}
