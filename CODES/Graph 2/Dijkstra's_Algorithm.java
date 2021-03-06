//Dijkstra's Algorithm
//
//Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.
//Find and print the shortest distance from the source vertex (i.e. Vertex 0) to all other vertices (including source vertex also) using Dijkstra's Algorithm.
//Print the ith vertex number and the distance from source in one line separated by space. Print different vertices in different lines.
//Note : Order of vertices in output doesn't matter.
//Input Format :
//Line 1: Two Integers V and E (separated by space)
//Next E lines : Three integers ei, ej and wi, denoting that there exists an edge between vertex ei and vertex ej with weight wi (separated by space)
//Output Format :
//In different lines, ith vertex number and its distance from source (separated by space)
//Constraints :
//2 <= V, E <= 10^5
//Sample Input 1 :
//4 4
//0 1 3
//0 3 5
//1 2 1
//2 3 8
//Sample Output 1 :
//0 0
//1 3
//2 4
//3 5

import java.util.*;
import java.math.*;

public class Solution {

    public static int getmin(int[] arr, boolean[] visited) {
        int min = -1;
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i] && (min == -1 || arr[min] > arr[i])) {
                min = i;
            }
        }
        return min;
    }

    public static void dijkastra(int[][] graph, int v, int start) {
        boolean[] visited = new boolean[v];
        int[] p = new int[v];
        int[] weight = new int[v];
        for (int i = 0; i < weight.length; i++) {
            p[i] = 0;
            weight[i] = Integer.MAX_VALUE;
        }
        p[start] = start;
        weight[start] = 0;
        int st = start;
        for (int j = 0; j < v; j++) {
            int min = getmin(weight, visited);
            visited[min] = true;
            for (int i = 0; i < graph[min].length; i++) {
                if (graph[min][i] > 0 && !visited[i]) {

                    if (weight[i] > (graph[min][i] + weight[min])) {
                        weight[i] = graph[min][i] + weight[min];
                        p[i] = min;
                    }
                }
            }
        }
        for (int i = 0; i < p.length; i++) {
            System.out.println(i + " " + weight[i]);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int V = s.nextInt();
        int E = s.nextInt();
        int[][] graph = new int[V][V];
        for (int i = 0; i < E; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();
            graph[a][b] = graph[b][a] = c;
        }
        dijkastra(graph, V, 0);

    }
}
