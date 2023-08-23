package com.example.demo.leetcode.test;

class NewCache {

    int DEFAULT_CAPACITY = 16;
    Node[] cache = new Node[DEFAULT_CAPACITY];

    public NewCache() {
    }

    public static void main(String[] args) {

        NewCache newCache = new NewCache();
        newCache.put(2, 3);
        newCache.put(4, 5);
        newCache.put(14, 7);
        System.out.println(newCache.get(4));
        System.out.println(newCache.get(14));
        System.out.println(newCache.get(3));

    }

    public int get(Integer key) {
        int hash = key % 10;
        Node node = cache[hash];
        if (node == null) {
            return -1;
        }
        do {
            if (node.key == key) {
                return (int) node.value;
            }
            node = node.next;
        }
        while (node != null);
        return -1;
    }

    public void put(Integer key, Integer value) {

        int hash = key % 10;
        if (cache[hash] != null) {
            Node node = cache[hash];
            if (node.key == key) {
                node.value = value;
                cache[hash] = node;
            } else {
                node = cache[hash];
                while (node.next != null) {
                    node = node.next;
                }
                Node newNode = new Node(key, value);
                node.next = newNode;
            }
        } else {
            Node newNode = new Node(key, value);
            newNode.hash = hash;
            this.cache[hash] = newNode;
        }
    }

    class Node<K, V> {
        K key;
        V value;
        int hash;
        Node next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }


    }
}