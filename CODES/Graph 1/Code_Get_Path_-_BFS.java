//Code : Get Path - BFS
//
//Given an undirected graph G(V, E) and two vertices v1 and v2(as integers), find and print the path from v1 to v2 (if exists). Print nothing if there is no path between v1 and v2.
//Find the path using BFS and print the shortest path available.
//V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
//E is the number of edges present in graph G.
//Print the path in reverse order. That is, print v2 first, then intermediate vertices and v1 at last.
//Note : Save the input graph in Adjacency Matrix.
//Input Format :
//Line 1: Two Integers V and E (separated by space)
//Next E lines : Two integers a and b, denoting that there exists an edge between vertex a and vertex b (separated by space)
//Line (E+2) : Two integers v1 and v2 (separated by space)
//Output Format :
//Path from v1 to v2 in reverse order (separated by space)
//Constraints :
//2 <= V <= 1000
//1 <= E <= 1000
//0 <= v1, v2 <= V-1
//Sample Input 1 :
//4 4
//0 1
//0 3
//1 2
//2 3
//1 3
//Sample Output 1 :
//3 0 1
//Sample Input 2 :
//6 3
//5 3
//0 1
//3 4
//0 3
//Sample Output 2 :

import java.util.*;

public class Solution {

    public static HashMap<Integer, Integer> BFSpath(boolean[][] graph, boolean[] visited, int from, int to) {

        visited[from] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(from);
        HashMap<Integer, Integer> map = new HashMap<>();
        while (q.size() > 0) {
            int prev = (int) q.poll();
            for (int i = 0; i < graph[prev].length; i++) {
                if (graph[prev][i] && !visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                    map.put(i, prev);
                    if (i == to) {
                        return map;
                    }

                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int V = s.nextInt();
        int E = s.nextInt();
        boolean[][] graph = new boolean[V][V];
        boolean[] visited = new boolean[V];
        for (int i = 0; i < E; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            graph[a][b] = true;
            graph[b][a] = true;
        }
        int from = s.nextInt();
        int to = s.nextInt();
        HashMap<Integer, Integer> map = BFSpath(graph, visited, from, to);
        if (map != null) {
            Integer v = to;
            System.out.print(to);
            while (v != from) {
                v = map.get(v);
                System.out.print(" " + v);
            }

        }

    }
}
