package com.example.demo.leetcode.test.dsa;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoom {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{0, 30}, {5, 16}, {15, 20}};
        System.out.println(totalMeetingRooms(intervals));
    }

    private static int totalMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= priorityQueue.peek()) {
                priorityQueue.poll();
            }
            priorityQueue.offer(intervals[i][1]);
        }
        return priorityQueue.size();
    }
}
