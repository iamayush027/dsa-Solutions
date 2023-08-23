package com.example.demo.leetcode.test.dsa;

public class NthMagicalNumber {
    public static void main(String[] args) {
//        System.out.println(nthMagicalNumber(1000000000, 40000, 40000));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }


    public static int nthMagicalNumber(int n, int a, int b) {
        int num = 1;
        int counter = 0;
        while (true) {
            if (num % a == 0 || num % b == 0) {
                counter++;
                if (counter == n)
                    return num;
            }
            num++;
        }
    }

    public static boolean isPalindrome(String s) {

        if (s.isEmpty()) {
            return true;
        }
        int start = 0;
        int last = s.length() - 1;
        while(start <= last) {
            char currFirst = s.charAt(start);
            char currLast = s.charAt(last);
            if (!Character.isLetterOrDigit(currFirst )) {
                start++;
            } else if(!Character.isLetterOrDigit(currLast)) {
                last--;
            } else {
                if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;

//        int start = 0;
//        int end = s.length() - 1;
//        while (start <= end) {
//            char firstChar = s.charAt(start);
//            char lastChar = s.charAt(end);
//            if (!Character.isLetterOrDigit(lastChar)) {
//                end--;
//            }
//            if (!Character.isLetterOrDigit(firstChar)) {
//                start++;
//            } else {
//                if (Character.toLowerCase(firstChar) != Character.toLowerCase(lastChar)) {
//                    return false;
//                }
//                start++;
//                end--;
//            }
//        }
//        return true;
    }


}
