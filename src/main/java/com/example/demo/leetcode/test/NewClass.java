package com.example.demo.leetcode.test;

public class NewClass {

    public static void main(String[] args) {
        int[] arr = {-2,-1,-3,-4,-1,-2,-1,-5,-4};
        System.out.println(maxSubArray(arr));
//        int n = 5;
//        int index = 0;
//        int duplicate;
//        int sum = 0;
//        for (int i : arr) {
//            sum += i;
//        }
//        System.out.println("XOR" + (5 ^ 4));
//        while (true) {
//            int num;
//            num = arr[index];
//            if ((num ^ index) == 0) {
//                duplicate = num;
//                break;
//            }
//
////                   if(num<0)
////                   {
////                      duplicate=Math.abs(num);
////                      break;
////                   }
////            arr[index]=num*(-1);
//            index = num;
//        }
//        System.out.println("DUPLIOCATE:" + duplicate);
//
//        int missingNum = sum - duplicate - 15;
//        System.out.println("Mising:" + missingNum);
    }

    public int strStr(String haystack, String needle) {
        // Base condition
        if (haystack == null || needle == null) {
            return -1;
        }
        // Special case
        if (haystack.equals(needle)) {
            return 0;
        }
        // length of the needle
        int needleLength = needle.length();
        // Loop through the haystack and slide the window
        for (int i = 0; i < haystack.length() - needleLength + 1; i++) {
            // Check if the substring equals to the needle
            if (haystack.substring(i, i + needleLength).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            max=Math.max(sum,max);
            sum= Math.max(sum, 0);
        }
        return max;
    }
}
