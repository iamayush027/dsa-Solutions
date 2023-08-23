package com.example.demo.leetcode.test.graph;

import java.util.*;

public class Graph {


    public static void main(String[] args) {

        int v = 5;
        List<Edge>[] graph = getAdjacentList(v);
        int[][] graphMatrix = getAdjacentmatrix(v);
        bfs(graph, v);
        System.out.println("TOPOLOGICAL********");
        topologicalSort(graph, v);
        System.out.println("IsCyclic for directed");
        System.out.println(isCycleExistInDirected(graph, v));
        System.out.println("****DIJTRAKS****");
        for (int value : dijkstras(graph, 0, v)) {
            System.out.print(value + " ");
        }
        System.out.println();
        System.out.println("BELLMAN FORD**********");
        for (int value : bellmanFord(graph, 0, v)) {
            System.out.print(value + " ");
        }
        System.out.println();
        primsAlgo(graph, 0, v);
        System.out.println("KOSARAJU---------");
        kosaRajuAlgo(graph, v);
    }

    private static int[][] kosaRajuAlgo(List<Edge>[] edge, int v) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) topSortForKosaRaju(edge, i, visited, stack);
        }

        List<Edge>[] tranpose = new List[v];
        for (int i = 0; i < v; i++) {
            visited[i] = false;
            tranpose[i] = new ArrayList<>();
        }
        for (int i = 0; i < v; i++) {
            for (Edge e : edge[i]) {
                tranpose[e.dest].add(new Edge(e.dest, e.src, e.weight));
            }
        }
        List<List<Integer>> mstList = new ArrayList<>();
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited[current]) {
                List<Integer> insideList = new ArrayList<>();
                bfsForKosaRaju(tranpose, current, visited, insideList);
                mstList.add(insideList);
            }

        }
        return null;
    }

    private static void bfsForKosaRaju(List<Edge>[] edge, int current, boolean[] visited, List<Integer> insideList) {
        visited[current] = true;
        insideList.add(current);
        System.out.print(current + " ");
        for (int i = 0; i < edge[current].size(); i++) {
            Edge e = edge[current].get(i);
            if (!visited[e.dest]) {
                bfsForKosaRaju(edge, e.dest, visited, insideList);
            }
        }


    }

    private static void topSortForKosaRaju(List<Edge>[] edges, int current, boolean[] visited, Stack<Integer> stack) {
        visited[current] = true;
        for (int i = 0; i < edges[current].size(); i++) {
            Edge e = edges[current].get(i);
            if (!visited[e.dest]) {
                topSortForKosaRaju(edges, e.dest, visited, stack);
            }
        }
        stack.push(current);
    }

    private static void primsAlgo(List<Edge>[] edges, int source, int v) {
        boolean[] visited = new boolean[v];
        PriorityQueue<CostPair> priorityQueue = new PriorityQueue<>();
        int mstCost = 0;
        List<Edge>[] mstEdges = new List[v];
        for (int i = 0; i < v; i++) {
            mstEdges[i] = new ArrayList<>();
        }
        priorityQueue.add(new CostPair(source, 0));
        while (!priorityQueue.isEmpty()) {
            CostPair costPair = priorityQueue.remove();
            if (!visited[costPair.node]) {
                visited[costPair.node] = true;
                mstEdges[costPair.node].add(new Edge(source, costPair.node, costPair.cost));
                mstCost += costPair.cost;
                for (int i = 0; i < edges[costPair.node].size(); i++) {
                    Edge edge = edges[costPair.node].get(i);
                    if (!visited[edge.dest]) {
                        priorityQueue.add(new CostPair(edge.dest, edge.weight));
                    }
                }
            }
        }
        System.out.println("cost of minimum spanning tree: " + mstCost);
        for (List<Edge> edgeList : mstEdges) {
            for (Edge e : edgeList) {
                System.out.print(e.src + " ----- " + e.dest + " (" + e.weight + " )");
            }
            System.out.println();
        }
    }

    private static int[] dijkstras(List<Edge>[] edges, int source, int v) {
        boolean[] visited = new boolean[v];
        int[] distance = new int[v];
        for (int i = 0; i < v; i++) {
            if (i == source) distance[i] = 0;
            else distance[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<Pair>();
        priorityQueue.add(new Pair(0, 0));
        while (!priorityQueue.isEmpty()) {
            Pair current = priorityQueue.remove();
            if (!visited[current.node]) {
                visited[current.node] = true;

                for (int i = 0; i < edges[current.node].size(); i++) {
                    Edge e = edges[current.node].get(i);
                    int src = e.src;
                    int dest = e.dest;
                    if (distance[src] + e.weight < distance[dest]) {
                        distance[dest] = distance[src] + e.weight;
                        priorityQueue.add(new Pair(dest, distance[dest]));
                    }

                }
            }
        }
        return distance;
    }

    private static int[] bellmanFord(List<Edge>[] edges, int source, int v) {
        boolean[] visited = new boolean[v];
        int[] distance = new int[v];
        for (int i = 0; i < v; i++) {
            if (i == source) distance[i] = 0;
            else distance[i] = Integer.MAX_VALUE;
        }
        for (int k = 0; k < v - 1; k++) {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < edges[i].size(); j++) {
                    Edge e = edges[i].get(j);
                    int src = e.src;
                    int dest = e.dest;
                    if (distance[src] != Integer.MAX_VALUE && distance[src] + e.weight < distance[dest]) {
                        distance[dest] = distance[src] + e.weight;
                    }
                }
            }
        }

        return distance;
    }

    private static boolean isCycleExistInDirected(List<Edge>[] edges, int v) {
        boolean[] visited = new boolean[v];
        boolean[] rec = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (isCycleExistInDirectedUtil(i, edges, v, visited, rec)) {
                    System.out.println("Cycle Exist");
                    return true;
                }
            }
        }
        System.out.println("Cycle does'nt exist");
        return false;
    }

    private static boolean isCycleExistInDirectedUtil(int curr, List<Edge>[] edges, int v, boolean[] visited, boolean[] rec) {
        visited[curr] = true;
        rec[curr] = true;
        for (int i = 0; i < edges[curr].size(); i++) {
            Edge e = edges[curr].get(i);
            if (rec[e.dest]) {
                return true;
            } else if (!visited[curr]) {
                if (isCycleExistInDirectedUtil(e.dest, edges, v, visited, rec)) return true;
            }
        }
        return false;
    }

    private static void bfs(List<Edge>[] edges, int v) {
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int vertex = queue.remove();
            if (!visited[vertex]) {
                System.out.println(vertex);
                visited[vertex] = true;
                for (Edge e : edges[vertex]) {
                    queue.add(e.dest);
                }
            }
        }

    }

    private static void topologicalSort(List<Edge>[] edges, int v) {
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < v; i++) {
            if (!visited[i]) topologicalSortUtil(edges, 0, visited, stack);
        }
        while (!stack.isEmpty()) {
            int value = stack.pop();
            System.out.println(value);
        }
    }

    private static void topologicalSortUtil(List<Edge>[] edges, int curr, boolean[] visited, Stack<Integer> stack) {
        visited[curr] = true;
        for (Edge e : edges[curr]) {
            if (!visited[e.dest]) {
                topologicalSortUtil(edges, e.dest, visited, stack);
            }
        }
        stack.push(curr);
    }

    private static int[][] getAdjacentmatrix(int v) {
        int[][] graphMatrix = new int[v][v];
        graphMatrix[0][0] = 0;
        graphMatrix[0][1] = 0;
        graphMatrix[0][2] = 0;
        graphMatrix[0][3] = 0;
        graphMatrix[0][4] = 0;
        graphMatrix[1][0] = 0;
        graphMatrix[1][1] = 0;
        graphMatrix[1][2] = 0;
        graphMatrix[1][3] = 0;
        graphMatrix[1][4] = 0;
        graphMatrix[2][0] = 0;
        graphMatrix[2][1] = 0;
        graphMatrix[2][2] = 0;
        graphMatrix[2][3] = 0;
        graphMatrix[2][4] = 0;
        graphMatrix[3][0] = 0;
        graphMatrix[3][1] = 0;
        graphMatrix[3][2] = 0;
        graphMatrix[3][3] = 0;
        graphMatrix[3][4] = 0;
        graphMatrix[4][0] = 0;
        graphMatrix[4][1] = 0;
        graphMatrix[4][2] = 0;
        graphMatrix[4][3] = 0;
        graphMatrix[4][4] = 0;
        return graphMatrix;
    }

    private static List<Edge>[] getAdjacentList(int v) {
        List<Edge>[] graph = new List[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 3, 10));
        graph[0].add(new Edge(0, 2, 15));
//        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 40));
        graph[2].add(new Edge(2, 1, 50));
//        graph[3].add(new Edge(2, 4, 60));

//        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4, 30));
//        graph[3].add(new Edge(3, 5, -1));
//        graph[5].add(new Edge(5, 6, 3));
        return graph;
    }

    private static class CostPair implements Comparable<CostPair> {
        int node;
        int cost;

        public CostPair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(CostPair costPair) {
            return this.cost - costPair.cost;
        }
    }

    private static class Pair implements Comparable<Pair> {
        int node;
        int distance;

        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Pair pair) {
            return this.distance - pair.distance;
        }
    }

    private static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
}
