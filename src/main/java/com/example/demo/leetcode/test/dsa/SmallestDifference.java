package com.example.demo.leetcode.test.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmallestDifference {
    public static void main(String[] args) {
        int[] arr={2,3,5,27,53,25,455,24,56,32,57,78};
        List<int[]> list=getDiff(arr);
        list.forEach(ints -> {
            System.out.println(ints[0]+"-"+ints[1]);
        });
    }
    private static List<int[]> getDiff(int[] arr)
    {
        Arrays.sort(arr);
        int maxDiff=Integer.MAX_VALUE;
        int currentDiff=0;
       List<int[]> result=new ArrayList<>();
        for(int i=1;i<arr.length-1;i++)
        {
            currentDiff=arr[i]-arr[i-1];
            if(currentDiff<maxDiff)
            {
                maxDiff=currentDiff;
                result.clear();
                result.add(new int[]{arr[i],arr[i-1]});
            }
            else if(currentDiff==maxDiff)
            {
                result.add(new int[]{arr[i],arr[i-1]});
            }
        }
        return result;
    }
}
