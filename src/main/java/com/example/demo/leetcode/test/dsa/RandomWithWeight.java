package com.example.demo.leetcode.test.dsa;

import java.util.Random;
import java.util.TreeMap;

public class RandomWithWeight {
    TreeMap<Integer, Integer> map;
    Random random = new Random();
    int sum = 0;

    public RandomWithWeight(int[] w) {
        map = new TreeMap<>();
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            map.put(sum, i);
        }
    }

    public static void main(String[] args) {
        RandomWithWeight obj = new RandomWithWeight(new int[]{1, 3});
        System.out.println(obj.pickIndex());
    }

    public int pickIndex() {
        return map.get(map.higherKey(random.nextInt(sum)));
    }
}
