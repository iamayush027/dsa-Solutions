package com.example.demo.memory;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;

public class MemoryMgt implements Runnable {

    @Override
    public void run() {
        StringBuilder sb = new StringBuilder();
        // ... your code that uses StringBuilder ...

        MemoryUsage memoryUsage = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
        long usedMemory = memoryUsage.getUsed();
        System.out.println("Used Memory: " + usedMemory + " bytes");
    }
}
