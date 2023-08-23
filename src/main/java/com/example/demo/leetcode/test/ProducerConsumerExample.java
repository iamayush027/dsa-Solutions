package com.example.demo.leetcode.test;

import java.util.concurrent.Semaphore;

class Buffer {
    private final int SIZE = 10;
    private int[] buffer;
    private int in, out;
    private Semaphore mutex, empty, full;

    public Buffer() {
        buffer = new int[SIZE];
        in = 0;
        out = 0;
        mutex = new Semaphore(1); // Mutual exclusion semaphore
        empty = new Semaphore(SIZE); // Semaphore to track empty slots
        full = new Semaphore(0); // Semaphore to track occupied slots
    }

    public void produce(int item) throws InterruptedException {

        empty.acquire(); // Wait for an empty slot
        mutex.acquire(); // Acquire mutex to access the buffer
        buffer[in] = item;
        in = (in + 1) % SIZE;
        System.out.println("Produced: " + item);
        mutex.release(); // Release mutex
        full.release(); // Signal that a slot is full
    }

    public int consume() throws InterruptedException {
        full.acquire(); // Wait for a full slot
        mutex.acquire(); // Acquire mutex to access the buffer
        int item = buffer[out];
        out = (out + 1) % SIZE;
        System.out.println("Consumed: " + item);
        mutex.release(); // Release mutex
        empty.release(); // Signal that a slot is empty
        return item;
    }
}

class Producer implements Runnable {
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                buffer.produce(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                int item = buffer.consume();
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ProducerConsumerExample {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}

