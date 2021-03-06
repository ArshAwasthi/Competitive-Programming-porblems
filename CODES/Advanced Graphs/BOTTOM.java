//BOTTOM
//
//We will use the following (standard) definitions from graph theory. Let V be a non-empty and finite set, its elements being called vertices (or nodes). Let E be a subset of the Cartesian product V×V, its elements being called edges. Then G=(V,E) is called a directed graph.
//
//Let n be a positive integer, and let p=(e1,…,en) be a sequence of length n of edges ei∈E such that ei=(vi,vi+1)for a sequence of vertices (v1,…,vn+1). Then p is called a path from vertex v1 to vertex vn+1 in G and we say that vn+1 is reachable from v1, writing (v1→vn+1).
//
//Here are some new definitions. A node v in a graph G=(V,E) is called a sink, if for every node w in G that is reachable from v, v is also reachable from w. The bottom of a graph is the subset of all nodes that are sinks, i.e., bottom(G)={v∈V∣∀w∈V:(v→w)⇒(w→v)}. You have to calculate the bottom of certain graphs.
//Input Specification
//The input contains several test cases, each of which corresponds to a directed graph G. Each test case starts with an integer number v, denoting the number of vertices of G=(V,E) where the vertices will be identified by the integer numbers in the set V={1,…,v}. You may assume that 1≤v≤5000. That is followed by a non-negative integer e and, thereafter, e pairs of vertex identifiers v1,w1,…,ve,we with the meaning that (vi,wi)∈E. There are no edges other than specified by these pairs. The last test case is followed by a zero.
//Output Specification
//For each test case output the bottom of the specified graph on a single line. To this end, print the numbers of all nodes that are sinks in sorted order separated by a single space character. If the bottom is empty, print an empty line.
//Sample Input
//3 3
//1 3 2 3 3 1
//2 1
//1 2
//0
//Sample Output
//1 3
//2

import java.util.*;

public class Main {

    public static void DFS(Vector<Vector<Integer>> graph, int start, Stack<Integer> stack, Set<Integer> visited) {
        visited.add(start);
        Vector<Integer> adj = graph.elementAt(start);
        for (Integer i : adj) {
            if (!visited.contains(i)) {
                DFS(graph, i, stack, visited);
            }
        }
        stack.push(start);
    }

    public static void TDFS(Vector<Vector<Integer>> graph, int start, HashSet<Integer> comp, Set<Integer> visited) {
        comp.add(start);
        visited.add(start);
        Vector<Integer> adj = graph.elementAt(start);
        for (Integer i : adj) {
            if (!visited.contains(i)) {
                TDFS(graph, i, comp, visited);
            }
        }
    }

    public static HashSet<Integer> bottom(Vector<Vector<Integer>> graph, Vector<Vector<Integer>> tgraph, int v) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < v; i++) {
            if (!visited.contains(i)) {
                DFS(graph, i, stack, visited);
            }
        }
        visited.clear();
        HashSet<HashSet<Integer>> comp = new HashSet<HashSet<Integer>>();
        while (stack.size() > 0) {
            int top = stack.pop();
            if (!visited.contains(top)) {
                HashSet<Integer> s = new HashSet<Integer>();
                TDFS(tgraph, top, s, visited);
                comp.add(s);
            }
        }
        HashSet<Integer> out = new HashSet<Integer>();
        for (HashSet<Integer> set : comp) {
            boolean flag = false;
            for (Integer node : set) {
                int temp = 0;
                Vector<Integer> vv = graph.elementAt(node);
                for (Integer j : vv) {
                    if (!set.contains(j)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
            if (flag == false) {
                out.addAll(set);
            } else {
                flag = false;
            }
        }
        return out;
    }

    public static void main(String[] args) {
        // Write your code here
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int v = in.nextInt();
            if (v == 0) {
                break;
            }
            int e = in.nextInt();
            Vector<Vector<Integer>> graph = new Vector<Vector<Integer>>();
            Vector<Vector<Integer>> tgraph = new Vector<Vector<Integer>>();
            for (int i = 0; i < v; i++) {
                graph.add(new Vector<Integer>());
                tgraph.add(new Vector<Integer>());
            }
            for (int i = 0; i < e; i++) {
                int v1 = in.nextInt() - 1;
                int v2 = in.nextInt() - 1;
                graph.elementAt(v1).add(v2);
                tgraph.elementAt(v2).add(v1);
            }
            HashSet<Integer> s = bottom(graph, tgraph, v);
            List<Integer> set = new ArrayList<Integer>(s);
            Collections.sort(set);
            for (Integer i : set) {

                System.out.print((i + 1) + " ");
            }
            System.out.println();
        }

    }

}
