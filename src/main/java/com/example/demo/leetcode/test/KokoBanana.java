package com.example.demo.leetcode.test;

public class KokoBanana {
    public static void main(String[] args) {
        int arr[]={312884470};
        int hour=312884469;

        System.out.println(minEatingSpeed(arr,hour));

    }

    public static int minEatingSpeed(int[] piles, int h) {
        int maxValue=0;
        int minValue=1;
        for(int j=0;j<piles.length;j++)
        {
            maxValue=Math.max(maxValue,piles[j]);
        }
        while (minValue<maxValue)
        {
            int mid= minValue+(maxValue-minValue)/2;
            if(canEatBanana(piles,h,mid))maxValue=mid;
            else minValue=mid+1;

        }
        return minValue;
    }
    private static boolean canEatBanana(int[] piles,int h,int k)
    {
        int hours=0;
        for(int i=0;i<piles.length;i++)
        {
            hours+=piles[i]/k;
            if(piles[i]%k>0)
            {
                hours++;
            }
        }
        return hours<=h;
    }


}
