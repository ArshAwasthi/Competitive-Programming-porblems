//Permutation Swaps
//
//Kevin has a permutation P of N integers 1, 2, ..., N, but he doesn't like it. Kevin wants to get a permutation Q.
//
//Also he believes that there are M good pairs of integers (ai , bi). Kevin can perform following operation with his permutation:
//
//Swap Px and Py only if (x, y) is a good pair.
//Help him and tell if Kevin can obtain permutation Q using such operations.
//Input format:
//The first line of input will contain an integer T, denoting the number of test cases.
//
//Each test case starts with two space-separated integers N and M. The next line contains N space-separated integers Pi. The next line contains N space-separated integers Qi. Each of the next M lines contains two space-separated integers ai and bi.
//Output format:
//For every test case output "YES" (without quotes) if Kevin can obtain permutation Q and "NO" otherwise.
//Constraints:
//1 ≤ T ≤ 10
//2 ≤ N ≤ 100000
//1 ≤ M ≤ 100000
//1 ≤ Pi, Qi ≤ N. Pi and Qi are all distinct.
//1 ≤ ai < bi ≤ N
//SAMPLE INPUT
//2
//4 1
//1 3 2 4
//1 4 2 3
//3 4
//4 1
//1 3 2 4
//1 4 2 3
//2 4
//SAMPLE OUTPUT
//NO 
//YES

import java.util.*;
import java.math.*;

public class Main {

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

    public static HashSet<HashSet<Integer>> components(Vector<HashSet<Integer>> graph, int size) {
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

    public static boolean check(Vector<HashSet<Integer>> graph, int[] arr1, int[] arr2) {
        HashSet<HashSet<Integer>> lst = components(graph, arr1.length);
        boolean[] ch = new boolean[arr1.length];
        for (HashSet<Integer> map : lst) {
            Vector<Integer> lst1 = new Vector<>();
            Vector<Integer> lst2 = new Vector<>();
            for (Integer i : map) {
                ch[i] = true;
                lst1.add(arr1[i]);
                lst2.add(arr2[i]);
            }
            if (lst1.containsAll(lst2) == false) {
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        // Write your code here
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for (int x = 0; x < cases; x++) {
            int size = in.nextInt();
            int edges = in.nextInt();
            Vector<HashSet<Integer>> adj = new Vector<>();
            int[] p1 = new int[size];
            int[] p2 = new int[size];
            for (int i = 0; i < size; i++) {
                adj.add(new HashSet<Integer>());
                p1[i] = in.nextInt();
            }

            for (int i = 0; i < size; i++) {
                p2[i] = in.nextInt();
            }

            for (int i = 0; i < edges; i++) {
                int v1 = in.nextInt() - 1;
                int v2 = in.nextInt() - 1;

                adj.elementAt(v1).add(v2);
                adj.elementAt(v2).add(v1);

            }
            boolean output = check(adj, p1, p2);
            if (output) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }

}
