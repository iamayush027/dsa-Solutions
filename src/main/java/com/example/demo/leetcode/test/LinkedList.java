package com.example.demo.leetcode.test;//package com.example.demo.test;
//// Java program to pairwise swap elements of a linked list
//import java.io.*;
//public class LinkedList {
//    Node head; // head of list
//
//    /* Linked list Node*/
//    class Node {
//        int data;
//        Node next;
//        Node(int d)
//        {
//            data = d;
//            next = null;
//        }
//    }
//
//    void pairWiseSwap()
//    {
//        Node temp = head;
//
//        /* Traverse only till there are atleast 2 nodes left */
//        while (temp != null && temp.next != null) {
//
//            /* Swap the data */
//            Node k = temp;
//            temp = temp.next;
//            temp.next = k;
//            temp=temp.next.next;
//            System.out.println(temp.data);
////            temp = temp.next.next;next
//        }
//    }
//
//    private Node swap(Node head)
//    {
//if(head==null || head.next==null)
//    return head;
//Node curNode=head;
//Node newhead=head.next;
//        while(curNode!=null && curNode.next!=null)
//        {
//            Node temp=curNode.next.next;
//            curNode.next.next=curNode;
//            curNode.next=temp;
//            curNode=temp;
//        }
//        return newhead;
//    }
//
//    /* Utility functions */
//
//    /* Inserts a new Node at front of the list. */
//    public void push(int new_data)
//    {
//		/* 1 & 2: Allocate the Node &
//				Put in the data*/
//        Node new_node = new Node(new_data);
//
//        /* 3. Make next of new Node as head */
//        new_node.next = head;
//
//        /* 4. Move the head to point to new Node */
//        head = new_node;
//    }
//
//    /* Function to print linked list */
//    void printList()
//    {
//        Node temp = head;
//        while (temp != null) {
//            System.out.print(temp.data + " ");
//            temp = temp.next;
//        }
//        System.out.println();
//    }
//    void printListByHead(Node head)
//    {
//        Node temp = head;
//        while (temp != null) {
//            System.out.print(temp.data + " ");
//            temp = temp.next;
//        }
//        System.out.println();
//    }
//
//
//    /* Driver program to test above functions */
//    public static void main(String args[])
//    {
//        LinkedList llist = new LinkedList();
//
//        /* Created Linked List 1->2->3->4->5 */
//        llist.push(5);
//        llist.push(4);
//        llist.push(3);
//        llist.push(2);
//        llist.push(1);
//
//        System.out.println("Linked List before calling pairWiseSwap() ");
//        llist.printList();
//
//        Node newhead=llist.swap(llist.head);
//        System.out.println(newhead);
//
//        System.out.println("Linked List after calling pairWiseSwap() ");
//        llist.printListByHead(newhead);
//    }
//}
///* This code is contributed by Rajat Mishra */
