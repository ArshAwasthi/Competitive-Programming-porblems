//Code : All connected components
//
//Given an undirected graph G(V,E), find and print all the connected components of the given graph G.
//V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
//E is the number of edges present in graph G.
//You need to take input in main and create a function which should return all the connected components. And then print them in the main, not inside function.
//Print different components in new line. And each component should be printed in increasing order (separated by space). Order of different components doesn't matter.
//Input Format :
//Line 1: Two Integers V and E (separated by space)
//Next 'E' lines, each have two space-separated integers, 'a' and 'b', denoting that there exists an edge between Vertex 'a' and Vertex 'b'.
//Output Format :
//Different components in new line
//Constraints :
//2 <= V <= 1000
//1 <= E <= 1000
//Sample Input 1:
//4 2
//0 1
//2 3
//Sample Output 1:
//0 1 
//2 3 
//Sample Input 2:
//4 3
//0 1
//1 3 
//0 3
//Sample Output 2:
//0 1 3 
//2

import java.util.*;

public class Solution {

    public static void DFS(boolean[][] graph, boolean[] visited, int start, Vector<Integer> lst) {
        visited[start] = true;
        lst.add(start);
        for (int i = 0; i < graph.length; i++) {
            if (graph[start][i] && !visited[i]) {
                DFS(graph, visited, i, lst);
            }
        }

    }

    public static Vector<Vector<Integer>> components(boolean[][] graph, boolean[] visited) {
        Vector<Vector<Integer>> v = new Vector<Vector<Integer>>();
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                Vector<Integer> comp = new Vector<>();
                DFS(graph, visited, i, comp);
                v.add(comp);
                //get graph            
            }
        }
        return v;
    }

    public static void DFS2(Vector<HashSet<Integer>> graph, HashSet<Integer> set, boolean[] visited, int start) {

        set.add(start);
        visited[start] = true;
        HashSet<Integer> mset = graph.elementAt(start);
        for (Integer i : mset) {
            if (!visited[i]) {
                DFS2(graph, set, visited, i);
            }
        }
    }

    public static HashSet<HashSet<Integer>> components2(Vector<HashSet<Integer>> graph, int size) {
        HashSet<HashSet<Integer>> lst = new HashSet<HashSet<Integer>>();
        boolean[] visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            HashSet<Integer> set = new HashSet<>();
            if (!visited[i]) {
                DFS2(graph, set, visited, i);
                lst.add(set);
            }

        }
        return lst;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int V = s.nextInt();
        int E = s.nextInt();
        Vector<HashSet<Integer>> adj = new Vector<>();

        for (int i = 0; i < V; i++) {
            adj.add(new HashSet<Integer>());
        }

        for (int i = 0; i < E; i++) {
            int v1 = s.nextInt();
            int v2 = s.nextInt();

            adj.elementAt(v1).add(v2);
            adj.elementAt(v2).add(v1);

        }
        HashSet<HashSet<Integer>> lst = components2(adj, V);
        for (HashSet<Integer> i : lst) {
            Vector<Integer> x = new Vector<>(i);
            Collections.sort(x);
            for (Integer j : x) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
