package com.example.demo.leetcode.test.dsa;

import java.util.ArrayList;

public class MedianFinder {
    ArrayList<Integer> nums;

    public MedianFinder() {
        nums = new ArrayList<>();

    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(3);
//        medianFinder.addNum(13);
//        medianFinder.addNum(6);
//        medianFinder.addNum(1);
//        System.out.println("l");
        // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian()); // return 2.0
    }

    public void addNum(int num) {
        int index=0;
       while (index<nums.size() && num>nums.get(index))index++;
       nums.add(index,num);

    }

    public double findMedian() {

        int length = nums.size();
        if (length == 0) return 0;
        if (length % 2 != 0) return nums.get(length / 2);
        else {
            int num1 = nums.get(length / 2);
            int num2 = nums.get((length / 2) - 1);
            return (double) (num1 + num2) / 2;
        }
    }
}
