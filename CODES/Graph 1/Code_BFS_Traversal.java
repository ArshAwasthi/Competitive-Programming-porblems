//Code : BFS Traversal
//
//Given an undirected and disconnected graph G(V, E), print its BFS traversal.
//Here you need to consider that you need to print BFS path starting from vertex 0 only.
//V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
//E is the number of edges present in graph G.
//Note : 1. Take graph input in the adjacency matrix.
//2. Handle for Disconnected Graphs as well
//Input Format :
//Line 1: Two Integers V and E (separated by space)
//Next 'E' lines, each have two space-separated integers, 'a' and 'b', denoting that there exists an edge between Vertex 'a' and Vertex 'b'.
//Output Format :
//BFS Traversal (separated by space)
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
//0 1 3 2

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int V = s.nextInt();
        int E = s.nextInt();
        boolean[][] graph = new boolean[V][V];
        boolean[] visited = new boolean[V];
        while (s.hasNext()) {
            int from = s.nextInt();
            int to = s.nextInt();
            graph[from][to] = graph[to][from] = true;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int j = 0; j < V; j++) {
            if (!visited[j]) {
                visited[j] = true;
                q.offer(j);
                while (q.size() > 0) {
                    // n++;
                    int first = (int) q.poll();
                    System.out.print(first + " ");
                    for (int i = 0; i < graph[first].length; i++) {
                        if (i == first) {
                            continue;
                        }
                        if (graph[first][i] && !visited[i]) {
                            q.offer(i);
                            visited[i] = true;

                        }
                    }
                }
            }
        }

    }
}
