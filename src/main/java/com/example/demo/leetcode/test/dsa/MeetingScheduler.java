package com.example.demo.leetcode.test.dsa;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetingScheduler {
    public static void main(String[] args) {
        int[][] slot1={{10,50},{60,120},{140,210}};
        int[][] slot2={{0,15},{60,70}};
        System.out.println(minAvailableSlot(slot1,slot2,8));
    }
    private static List<Integer> minAvailableSlot(int[][] slot1, int[][] slot2, int duration)
    {
        Arrays.sort(slot1, (a, b) -> {
            if (a[0] == b[0])
                return Integer.compare(a[1], b[1]);
            else return Integer.compare(a[0], b[0]);
        });
        Arrays.sort(slot2, (a, b) -> {
            if (a[0] == b[0])
                return Integer.compare(a[1], b[1]);
            else return Integer.compare(a[0], b[0]);
        });

        int i=0,j=0;
        while (i<slot1.length && j<slot2.length)
        {
            int start=Math.max(slot1[i][0],slot2[j][0]);
            int end=Math.min(slot1[i][1],slot2[j][1]);
            if(start+duration<=end) return new ArrayList<>(List.of(start,start+duration));
            if(slot1[i][1]<slot2[j][1])++i;
            else ++j;

        }
        return new ArrayList<>();
    }
}
