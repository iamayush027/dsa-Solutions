package com.example.demo.leetcode.test.dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScedule {
    public static void main(String[] args) {
        int[][] edge = new int[][]{{0, 1}};
        System.out.println(canFinish(2, edge));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] edge = new List[numCourses];
        int[] inDegree = new int[numCourses];
        List<Integer> result = new ArrayList<>();

        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];
            if (edge[prerequisite] == null) {
                edge[prerequisite] = new ArrayList<>();
            }
            edge[prerequisite].add(course);
            inDegree[course]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);
            if (edge[current] != null) {
                for (int node : edge[current]) {
                    inDegree[node]--;
                    if (inDegree[node] == 0) queue.offer(node);
                }
            }
        }
        return result.size() == numCourses;

    }

}
