package com.example.demo.leetcode.test.dsa;

public class StoneGame {

    public static void main(String[] args) {
        int arr[] = {3,7,2,3};
        System.out.println(stoneGame(arr));
    }

    public static boolean stoneGame(int[] pile) {
        int aliceCount = 0;
        int bobCount = 0;
        int left = 0;
        int right = pile.length -1;
        int counter=0;
        boolean flag = true;

        while (left <= right) {
            if (pile[left] >= pile[right]) {
                if (counter%2==0) {
                    aliceCount += pile[left];
                } else {
                    bobCount += pile[left];
                }

                left++;
            } else {
                if (counter%2==0) {
                    aliceCount += pile[right];
                    flag = false;
                } else {
                    bobCount += pile[right];
                    flag = true;
                }
                right--;
            }
            counter++;
        }
        System.out.println(aliceCount);
        System.out.println(bobCount);
        return aliceCount >= bobCount;
    }
}
