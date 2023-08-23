package com.example.demo.leetcode.test.dsa;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosest {
    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {-2, 2}};
        int[][] rs = kClosest(arr, 1);
        for (int i = 0; i < rs.length; i++) {
            System.out.println(rs[i][0] + " " + rs[i][1]);
        }
    }

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(k, Comparator.comparing(Pair::getDist));
        for (int i = 0; i < points.length; i++) {
            double distance = Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2);
            distance = Math.sqrt(distance);
            priorityQueue.add(new Pair(points[i][0], points[i][1], distance));
        }
        int index = 0;
        int[][] result = new int[k][2];
        while (!priorityQueue.isEmpty() && index<k) {
            Pair pair = priorityQueue.remove();
            result[index][0] = pair.getPoint1();
            result[index][1] = pair.getPoint2();
            index++;
        }
        return result;
    }

    private static class Pair {
        int point1;
        int point2;
        double dist;

        public Pair(int point1, int point2, double dist) {
            this.point1 = point1;
            this.point2 = point2;
            this.dist = dist;
        }

        public int getPoint1() {
            return point1;
        }

        public void setPoint1(int point1) {
            this.point1 = point1;
        }

        public int getPoint2() {
            return point2;
        }

        public void setPoint2(int point2) {
            this.point2 = point2;
        }

        public double getDist() {
            return dist;
        }

        public void setDist(double dist) {
            this.dist = dist;
        }
    }
}
