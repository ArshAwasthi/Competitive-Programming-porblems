//Prim's Algorithm
//
//Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.
//Find and print the Minimum Spanning Tree (MST) using Prim's algorithm.
//For printing MST follow the steps -
//1. In one line, print an edge which is part of MST in the format -
//v1 v2 w
//where, v1 and v2 are the vertices of the edge which is included in MST and whose weight is w. And v1 <= v2 i.e. print the smaller vertex first while printing an edge.
//2. Print V-1 edges in above format in different lines.
//Note : Order of different edges doesn't matter.
//Input Format :
//Line 1: Two Integers V and E (separated by space)
//Next E lines : Three integers ei, ej and wi, denoting that there exists an edge between vertex ei and vertex ej with weight wi (separated by space)
//Output Format :
//MST
//Constraints :
//2 <= V, E <= 10^5
//Sample Input 1 :
//4 4
//0 1 3
//0 3 5
//1 2 1
//2 3 8
//Sample Output 1 :
//0 1 3
//1 2 1
//0 3 5

import java.util.*;
import java.math.*;

class edge {

    public int v1;
    public int v2;
    public int w;

    edge() {
        v2 = 0;
        w = Integer.MAX_VALUE;
    }

    edge(int a, int b, int c) {
        v1 = a;
        v2 = b;
        w = c;
    }
}

public class Solution {

    public static int getMin(edge[] weight, boolean[] visited, int st) {
        int min = -1;
        for (int i = 0; i < weight.length; i++) {
            if (!visited[i] && (min == -1 || weight[min].w > weight[i].w)) {
                min = i;
            }
        }
        return min;
    }

    public static void prims(int[][] graph, int v) {
        boolean[] visited = new boolean[v];
        edge[] ed = new edge[v];
        for (int i = 0; i < v; i++) {
            ed[i] = new edge();
        }
        ed[0] = new edge(0, -1, 0);
        for (int x = 0; x < v; x++) {
            int min = getMin(ed, visited, x);
            visited[min] = true;
            for (int i = 0; i < graph[min].length; i++) {
                if (graph[min][i] > 0 && !visited[i]) {
                    if (graph[min][i] < ed[i].w) {
                        ed[i].w = graph[min][i];
                        ed[i].v2 = min;
                    }
                }
            }
        }
        for (int i = 1; i < ed.length; i++) {
            System.out.println(Math.min(i, ed[i].v2) + " " + Math.max(i, ed[i].v2) + " " + ed[i].w);
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

        prims(graph, V);

    }
}
