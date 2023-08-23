package com.example.demo.leetcode.test.dsa;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class TimeMap {
    Map<String, TreeMap<Integer, String>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
        System.out.println(timeMap.get("foo", 1));
        System.out.println(timeMap.get("foo", 3));         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
        System.out.println(timeMap.get("foo", 4));         // return "bar2"
        System.out.println(timeMap.get("foo", 5));
    }

    public void set(String key, String value, int timestamp) {
        if (timeMap.containsKey(key)) {
            TreeMap<Integer, String> map = timeMap.get(key);
            map.put(timestamp, value);
        } else {
            TreeMap<Integer, String> map = new TreeMap<>();
            map.put(timestamp, value);
            timeMap.put(key, map);
        }
    }

    public String get(String key, int timestamp) {

        if (timeMap.containsKey(key)) {
            TreeMap<Integer, String> map = timeMap.get(key);
            Integer prevTimeStamp = map.floorKey(timestamp);
            if (prevTimeStamp != null) return map.get(prevTimeStamp);
        }

        return "";

    }
}
