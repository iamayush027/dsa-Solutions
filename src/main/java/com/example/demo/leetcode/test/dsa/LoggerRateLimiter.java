package com.example.demo.leetcode.test.dsa;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {
    static Map<String, Integer> stringIntegerMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(shouldPrintMessage(1, "foo"));
        System.out.println(shouldPrintMessage(2, "bar"));
        System.out.println(shouldPrintMessage(3, "foo"));
        System.out.println(shouldPrintMessage(8, "bar"));
        System.out.println(shouldPrintMessage(10, "foo"));
        System.out.println(shouldPrintMessage(11, "foo"));

    }


    private static boolean shouldPrintMessage(int timestamp, String message) {
        if (stringIntegerMap.containsKey(message)) {
            if (timestamp - stringIntegerMap.get(message) >= 10) {
                return true;
            }
            return false;
        }
        else {
            stringIntegerMap.put(message, timestamp);
            return true;
        }
    }
}
