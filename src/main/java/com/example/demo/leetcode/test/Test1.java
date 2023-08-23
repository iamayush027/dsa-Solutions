package com.example.demo.leetcode.test;//package com.example.demo.test;
//
//import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
//
//import java.util.*;
//
//public class Test1 {
//    public static void main(String[] args) {
////        List<Integer> numList = List.of(1, 2, 4, 5, 7, 8, 9);
////        int[] arr = {1,2,3,4};
////        int result = maximumProduct(arr);
////        System.out.println("TEST: " + result);
//        String str="abcd";
//        String goal="dabc";
//        System.out.println(isCyclicRotation(str,goal));
//    }
//
//    public static boolean isCyclicRotation(String p,
//                                           String q)
//    {
//
//        int[] a;
//        a.length;
//        int i = 0, j = 0, k = 0, n = p.length();
//        boolean reset = false;
//        while (i < 2 * n) {
//            if (k == n) {
//                return true;
//            }
//            if (p.charAt(i % n) == q.charAt(j % n)) {
//                i++;
//                j++;
//                k++;
//            }
//            else if (reset) {
//                reset = false;
//                i++;
//            }
//            else {
//                reset = true;
//                j = 0;
//                k = 0;
//            }
//        }
//        return false;
//    }
//    public static int maximumProduct(int[] nums) {
//        int max1 = Integer.MIN_VALUE;
//        int max2 = Integer.MIN_VALUE;
//        int max3 = Integer.MIN_VALUE;
//        int min1 = Integer.MAX_VALUE;
//        int min2 = Integer.MAX_VALUE;
//        if (nums.length < 3) {
//            return -1;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] < min1) {
//                min2 = min1;
//                min1 = nums[i];
//            } else if (nums[i] < min2) {
//                min2 = nums[i];
//            }
//
//            if (nums[i] > max1) {
//                max3 = max2;
//                max2 = max1;
//                max1 = nums[i];
//            } else if (nums[i] > max2) {
//                max3 = max2;
//                max2 = nums[i];
//            } else if (nums[i] > max3) {
//                max3 = nums[i];
//            }
//        }
//        System.out.println("NUMBERS");
//        System.out.println(max1);
//        System.out.println(max2);
//        System.out.println(max3);
//        System.out.println(min1);
//        System.out.println(min2);
//        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
//    }
//
//}
//
