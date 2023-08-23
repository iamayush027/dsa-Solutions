package com.example.demo.leetcode.test.dsa;

public class MergeList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode response= mergeTwoLists(head,head2);
        while (response.next!=null)
        {
            System.out.print(response.val);
            response=response.next;
        }
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1==null) return list2;
        if(list2==null) return list1;

        if(list1.val<list2.val)
        {
            list1.next=mergeTwoLists(list1.next,list2);
            return list1;
        }
        else {
            list2.next=mergeTwoLists(list1,list2.next);
            return list2;
        }
    }
}
