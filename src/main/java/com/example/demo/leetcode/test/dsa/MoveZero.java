package com.example.demo.leetcode.test.dsa;

public class MoveZero {
    public static void main(String[] args) {
       int[] arr={1,3,0,2,0,4,5};
       moveZero(arr);
    }

    private static void moveZero(int[] arr)
    {
        int nonZero=0;
        for(int i=0;i< arr.length;i++)
        {
            if(arr[i]!=0)
            {
                arr[nonZero++]=arr[i];
            }

        }

        for(int i=nonZero ;i<arr.length;i++)
        {
            arr[i]=0;
        }
        for (int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]);
        }
    }

}
