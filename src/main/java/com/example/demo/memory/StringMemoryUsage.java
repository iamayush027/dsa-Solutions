package com.example.demo.memory;

public class StringMemoryUsage {
    public static void main(String[] args) {
        final int numberOfThreads =2000;
        final int stringLength = 100; // Length of the string

        Thread[] threads = new Thread[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(() -> {
                String str = new String(new char[stringLength]);
                synchronized (StringMemoryUsage.class) {
                    try {
                        StringMemoryUsage.class.wait(); // Prevent garbage collection
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
            threads[i].start();
        }
        System.out.println("1");
        // Wait for all threads to be started
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("2");
        // Calculate memory usage
        long memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Memory used: " + memoryUsed / (1024 * 1024) + " MB");

        // Allow garbage collection
        synchronized (StringMemoryUsage.class) {
            StringMemoryUsage.class.notifyAll();
        }

        // Wait for a moment to allow the threads to finish and the objects to be collected
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Memory used after releasing objects: " + memoryUsed / (1024 * 1024) + " MB");
    }
}

