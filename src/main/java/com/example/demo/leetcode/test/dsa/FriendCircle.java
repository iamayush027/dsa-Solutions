package com.example.demo.leetcode.test.dsa;

public class FriendCircle {


    public static void main(String[] args) {
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(findCircleNum(isConnected));
    }

    public static int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    private static void dfs(int[][] isConnected, boolean[] visited, int current) {

        for (int x = 0; x < isConnected[current].length; x++) {
            if (isConnected[current][x] != 0 && !visited[x]) {
                visited[x] = true;
                dfs(isConnected, visited, x);
            }
        }
    }

}
