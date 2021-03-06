//Code : Has Path
//
//Given an undirected graph G(V, E) and two vertices v1 and v2(as integers), check if there exists any path between them or not. Print true or false.
//V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
//E is the number of edges present in graph G.
//Input Format :
//Line 1: Two Integers V and E (separated by space)
//Next E lines : Two integers a and b, denoting that there exists an edge between vertex a and vertex b (separated by space)
//Line (E+2) : Two integers v1 and v2 (separated by space)
//Output Format :
//true or false
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
//true
//Sample Input 2 :
//6 3
//5 3
//0 1
//3 4
//0 3
//Sample Output 2 :
//false


import java.util.*;

public class Solution {

    public static boolean getPath(boolean[][] graph, boolean[] visited, int from, int to) {
        if (from == to) {
            return true;
        }
        visited[from] = true;
        for (int i = 0; i < graph[from].length; i++) {
            if (graph[from][i] && !visited[i]) {

                visited[i] = true;
                if (getPath(graph, visited, i, to)) {
                    return true;
                }
            }
        }
        return false;
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
        if (graph[from][to] || graph[to][from]) {
            System.out.println(true);
            return;
        }
        System.out.println(getPath(graph, visited, from, to));

    }
}
