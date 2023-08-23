package com.example.demo.leetcode.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class  Khoros {
    public static void main(String[] args) {
        List<String> stringList = List.of("ram", "ram", "sham", "Sham", "raghu");
        HashMap<String, Integer> hashMap = new HashMap<>();
        stringList.forEach(str -> {
            String key = str.toLowerCase();
            if (hashMap.containsKey(key)) {
                int count = hashMap.get(key);
                hashMap.put(key, ++count);
            } else {
                hashMap.put(key, 1);
            }
        });
        List<Map.Entry<String, Integer>> result = hashMap
                .entrySet()
                .stream()
                .sorted((Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) -> obj2.getValue().compareTo(obj1.getValue()))
                .collect(Collectors.toList());
        if (result.size() == 0) {
            System.out.println(result.get(0).getKey());
            return;
        }
        int maxCount = result.get(0).getValue();
        result.remove(0);
        Optional<Map.Entry<String, Integer>> finalResult = result.stream().filter(stringIntegerEntry -> stringIntegerEntry.getValue() != maxCount).findFirst();
        if (result.size() == 0) {
            System.out.println("EMPTY");
            return;
        }
        String response = finalResult.get().getKey();
        System.out.println("FINAL:" + response);
    }
}
