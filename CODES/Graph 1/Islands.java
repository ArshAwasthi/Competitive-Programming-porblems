//Islands
//
//An island is a small piece of land surrounded by water . A group of islands is said to be connected if we can reach from any given island to any other island in the same group . Given N islands (numbered from 1 to N) and two lists of size M (u and v) denoting island u[i] is connected to island v[i] and vice versa . Can you count the number of connected groups of islands.
//Constraints :
//1<=N<=100
//1<=M<=(N*(N-1))/2
//1<=u[i],v[i]<=N
//Input Format :
//Line 1 : Two integers N and M
//Line 2 : List u of size of M
//Line 3 : List v of size of M
//Output Return Format :
//The count the number of connected groups of islands
//Sample Input :
//2 1
//1
//2
//Sample Output :
//1 

public class solution {

    public void DFS(boolean[][] graph, boolean[] visited, int start) {
        visited[start] = true;
        for (int i = 0; i < graph.length; i++) {
            if (graph[start][i] && !visited[i]) {
                DFS(graph, visited, i);
            }
        }
    }

    public int solve(int n, int m, int U[], int V[]) {
        //write your code here
        boolean[][] graph = new boolean[n][n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < m; i++) {
            graph[U[i] - 1][V[i] - 1] = graph[V[i] - 1][U[i] - 1] = true;
        }
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                DFS(graph, visited, i);
            }
        }
        return components;
    }
}
