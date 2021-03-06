//Code : Is Connected ?
//
//Given an undirected graph G(V,E), check if the graph G is connected graph or not.
//V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
//E is the number of edges present in graph G.
//Input Format :
//Line 1: Two Integers V and E (separated by space)
//Next 'E' lines, each have two space-separated integers, 'a' and 'b', denoting that
//there exists an edge between Vertex 'a' and Vertex 'b'.
//Output Format :
//"true" or "false"
//Constraints :
//2 <= V <= 1000
//1 <= E <= 1000
//Sample Input 1:
//4 4
//0 1
//0 3
//1 2
//2 3
//Sample Output 1:
//true
//Sample Input 2:
//4 3
//0 1
//1 3 
//0 3
//Sample Output 2:
//false 
//Sample Output 2 Explanation
//The graph is not connected, even though vertices 0,1 and 3 are connected to each other 
//but there isn’t any path from vertices 0,1,3 to vertex 2. 


import java.util.*;

public class Solution {

    public static boolean DFSconnect(boolean[][] graph, boolean[] visited, Vector n, int start) {
        visited[start] = true;
        if ((Integer) n.elementAt(0) <= 1) {
            return true;
        }
        for (int i = 0; i < graph[start].length; i++) {
            if (graph[start][i] && !visited[i]) {
                n.add(0, (Integer) n.elementAt(0) - 1);
                if (DFSconnect(graph, visited, n, i)) {
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
        Vector<Integer> v = new Vector<>();
        v.add(V);
        System.out.println(DFSconnect(graph, visited, v, 0));

    }
}
