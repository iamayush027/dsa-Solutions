package com.example.demo.leetcode.test.dsa;

import java.util.Arrays;

public class RankTeam {
    public static void main(String[] args) {
        String[] votes = {"WXYZ","XYZW"};
        System.out.println(rankTeams(votes));
    }

    public static String rankTeams(String[] votes) {
        StringBuffer stringBuffer = new StringBuffer();
        int n = votes.length;
        int len=votes[0].length() ;
        int[][] map = new int[26][len + 1];
        for (int i = 0; i < 26; i++) map[i][len] = i;
        for (int i = 0; i < votes.length; i++) {
            String str = votes[i];
            for (int j = 0; j < str.length(); j++) {
                map[str.charAt(j) - 'A'][j]++;
            }
        }
        Arrays.sort(map, (a, b) -> {
            for (int i = 0; i < len; i++) {
                int comp = Integer.compare(b[i], a[i]);
                if (comp != 0) return comp;
            }
            return 0;
        });
        for (int i = 0; i < len; i++) {
            stringBuffer.append((char) ('A' + map[i][len]));
        }
        return stringBuffer.toString();

    }

}
