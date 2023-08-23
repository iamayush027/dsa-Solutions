package com.example.demo.leetcode.test.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    public static void main(String[] args) {
        int[][] interval = new int[][]{{1, 3}, {8, 10}, {2, 6}, {2, 4}, {15, 18}};
        int[][] result = merge(interval);
        for (int i=0;i<result.length;i++)
        {
            System.out.println(result[i][0]+" - "+result[i][1]);
        }

    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0])
                return Integer.compare(a[1], b[1]);
            else return Integer.compare(a[0], b[0]);
        });
        List<int[]> merged=new ArrayList<>();
        int[] mergedInterval=intervals[0];

        for(int i=1;i<intervals.length;i++)
        {
            if(mergedInterval[1]>=intervals[i][0])
            {
                mergedInterval[1]=Math.max(mergedInterval[1],intervals[i][1]);
            }else {
                merged.add(mergedInterval);
                mergedInterval=intervals[i];
            }
        }
        merged.add(mergedInterval);
        return  merged.toArray(new int[merged.size()][]);

    }

}
