package com.example.demo.leetcode.test.FrogJump;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int arr[] = new int[5];
        arr[1]++;
        arr[2]++;
        for (int i = 0; i < 5; i++) {
            System.out.print(arr[i]);
        }
    }

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] inDegree = new int[n];
        for (List<Integer> edge : edges) {
            inDegree[edge.get(1)]++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }
}
