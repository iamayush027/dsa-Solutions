package com.example.demo.leetcode.test;

public class LinkedListFunctions {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);
//        linkedList.insert(5);
        linkedList.display();
        linkedList.reverse(LinkedList.head);
        System.out.println(" ");
        linkedList.display();
    }

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            next = null;
        }
    }

    static class LinkedList {
        static Node head;

        public void insert(int val) {
            if (head == null) {
                Node node = new Node(val);
                head = node;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                Node newNode = new Node(val);
                temp.next = newNode;
            }
        }

        public void reverse(Node node)//4 3
        {
            Node prev = null;
            Node current = node;
            Node next = null;
            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            head = prev;

        }

        public void display() {
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.val);
                temp = temp.next;
            }
        }
    }

}
