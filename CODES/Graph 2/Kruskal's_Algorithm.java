//Kruskal's Algorithm
//
//Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.
//Find and print the Minimum Spanning Tree (MST) using Kruskal's algorithm.
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
//1 2 1
//0 1 3
//0 3 5

import java.util.*;
import java.math.*;

class edge {

    public int v1;
    public int v2;
    public int w;

    edge() {

    }

    edge(int v1, int v2, int w) {
        this.v1 = v1;
        this.v2 = v2;
        this.w = w;
    }
}

class way implements Comparator<edge> {

    @Override
    public int compare(edge a, edge b) {
        return a.w - b.w;
    }
}

public class Solution {

    public static boolean unionFind(int[] arr, int v1, int v2) {
        int p1 = v1;
        int p2 = v2;
        for (int i = 0; i < arr.length; i++) {
            if (arr[p1] == p1 && arr[p2] == p2) {
                break;
            }
            if (arr[p1] != p1) {
                p1 = arr[p1];
            }
            if (arr[p2] != p2) {
                p2 = arr[p2];
            }
        }
        if (p1 != p2) {
            arr[p2] = arr[p1];
            return true;
        }
        return false;
    }

    public static void krushkal(edge[] graph, int v) {
        int[] arr = new int[v];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        int count = 0;
        int i = 0;
        while (count < v && i < graph.length) {
            if (unionFind(arr, graph[i].v1, graph[i].v2)) {
                System.out.println(Math.min(graph[i].v1, graph[i].v2) + " " + Math.max(graph[i].v1, graph[i].v2) + " " + graph[i].w);
                count++;
            }

            i++;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int V = s.nextInt();
        int E = s.nextInt();
        edge[] graph = new edge[E];

        boolean[] visited = new boolean[V];
        for (int i = 0; i < E; i++) {
            graph[i] = new edge(s.nextInt(), s.nextInt(), s.nextInt());
        }
        Arrays.sort(graph, new way());
        krushkal(graph, V);
    }
}
