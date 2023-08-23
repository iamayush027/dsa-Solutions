package com.example.demo.leetcode.test.dsa;

public class KMPAlgorithm {
    public static void main(String[] args) {
        String pat = "AAAA";
        String str = "AAAAABAAABA";
        int lps[] = new int[pat.length()];
        computeLPS(pat, pat.length(), lps);
        int patLength = pat.length();
        int strLength = str.length();
        int i = 0;
        int j = 0;
        while ((strLength - i) > (patLength - j)) {
            if (str.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
            if (j == patLength) {
                System.out.println("Patter found");
                break;
            } else if (i < strLength && str.charAt(i) != pat.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else i += 1;
            }
        }
    }

    private static void computeLPS(String str, int m, int lps[]) {
        int len = 0;
        int i = 1;
        lps[0] = 0;
        while (i < m) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {

                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}
