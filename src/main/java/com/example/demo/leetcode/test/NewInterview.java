package com.example.demo.leetcode.test;

import java.util.Arrays;

public class NewInterview {

    public static void main(String[] args) {
        int arr[]={1,1,2,2,3,3};
        rotate(arr);
//        System.out.println(maxProfit(arr));
//        System.out.println(removeDuplicates(arr));
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]);
        }
//     int start=0;
//
//            int arr[]={1,0,0,2,2,1,2,1,0};
//            int end=arr.length-1;
//
//            for(int i=0;i<arr.length;i++)
//            {
//             if(arr[i]==0)
//             {
//                 int temp=arr[i];
//                 arr[i]=arr[start];
//                 arr[start]=temp;
//                 start++;
//             }
//             if(arr[i]==2) {
//                 int temp=arr[i];
//                 arr[i]=arr[end];
//                 arr[end]=temp;
//                 end--;
//             }
//
//
//            }
//
//            for(int i=0;i<arr.length;i++)
//            {
//                System.out.print(arr[i]);
//            }


    }


    public static int removeDuplicates(int[] nums) {
        int addIndex=1;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]<nums[i+1])
            {
                nums[addIndex]=nums[i+1];
                addIndex++;
            }

        }return addIndex;
    }
    public static int maxProfit(int[] prices) {
        int maxProfit=0;
        for(int i=0;i<prices.length-1;i++)
        {
            if(prices[i]<prices[i+1])
            {
                maxProfit+=prices[i+1]=prices[i];
            }
        }
        return maxProfit;
    }
    public void rotate(int[] nums, int k) {

        int endNum=nums[nums.length-1];
        int prev=nums[0];
        for(int i=0;i< nums.length-1;i++)
        {
            int tempNum=nums[i+1];
            nums[i+1]=nums[i];
            prev=nums[i];

        }
    }

    public static void rotate(int[] arr)
    {
        int start=0;
        int end=arr.length-1;
        while (start<end)
        {
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
}



