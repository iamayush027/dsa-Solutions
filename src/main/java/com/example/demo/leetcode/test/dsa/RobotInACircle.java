package com.example.demo.leetcode.test.dsa;

public class RobotInACircle {
    public static void main(String[] args) {
        System.out.println(isRobotBounded("GGLLCC"));
    }

    public static boolean isRobotBounded(String instructions) {
        int[][] dir = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        int x = 0, y = 0;
        int direction = 0;
        for (char ch : instructions.toCharArray()) {
            if (ch == 'L') {
                direction = (direction + 1) % 4;
            } else if (ch == 'R') {
                direction = (direction + 3) % 4;
            } else {
                x +=  dir[direction][0];
                y +=  dir[direction][1];
            }
        }
        return (x == 0 && y == 0 || direction != 0);
    }
}
