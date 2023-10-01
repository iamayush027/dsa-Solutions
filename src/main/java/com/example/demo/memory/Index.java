package com.example.demo.memory;

public class Index {
    public static void main(String[] args) throws InterruptedException {
        int numberOfThreads = 2000;

        MemoryMgt memoryMgt = new MemoryMgt();
        memoryMgt.run();

        for (int i = 0; i < numberOfThreads; i++) {
            Thread thread = new Thread(new StringThread());
            thread.start();



        }
        memoryMgt.run();
        System.out.println("For String");

    }
}
