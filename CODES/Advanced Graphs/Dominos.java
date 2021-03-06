//Dominos
//
//Domino
//Dominos are lots of fun. Children like to stand the tiles on their side in long lines. When one domino falls, it knocks down the next one, which knocks down the one after that, all the way down the line.
//However, sometimes a domino fails to knock the next one down. In that case, we have to knock it down by hand to get the dominos falling again.
//Your task is to determine, given the layout of some domino tiles, the minimum number of dominos that must be knocked down by hand in order for all of the dominos to fall.
//Input
//The first line of input contains one integer specifying the number of test cases to follow.Each test case begins with a line containing two integers,each no larger than 100 000. The first integer n is the number of domino tiles and the second integer m is the number of lines to follow in the test case. The domino tiles are numbered from 1 to n.
//Each of the following lines contains two integers x and y indicating that if domino number x falls, it will cause domino number y to fall as well.
//Output
//For each test case, output a line containing one integer, the minimum number of dominos that must be knocked over by hand in order for all the dominos to fall.
//Sample Input
//1
//3 2
//1 2
//2 3
//Sample Output
//1


import java.util.*;
import java.math.*;

public class Main {

    public static void DFS(Vector<Vector<Integer>> graph, int start, Stack<Integer> st, HashSet<Integer> visited) {
        visited.add(start);

        Vector<Integer> adj = graph.elementAt(start);
        for (Integer i : adj) {
            if (!visited.contains(i)) {
                DFS(graph, i, st, visited);
            }
        }
        st.push(start);

    }

    public static void TDFS(Vector<Vector<Integer>> graph, int start, HashSet<Integer> visited) {
        visited.add(start);
        Vector<Integer> adj = graph.elementAt(start);
        for (Integer i : adj) {
            if (!visited.contains(i)) {
                TDFS(graph, i, visited);
            }
        }

    }

    public static int kosaRaju(Vector<Vector<Integer>> graph, int v) {
        Stack<Integer> st = new Stack();
        int output = 0;
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < v; i++) {
            if (!visited.contains(i)) {
                DFS(graph, i, st, visited);
            }
        }
        visited.clear();
        while (st.size() > 0) {
            int top = st.pop();
            if (!visited.contains(top)) {
                output++;
                TDFS(graph, top, visited);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        // Write your code here
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for (int x = 0; x < cases; x++) {
            int v = in.nextInt();
            int e = in.nextInt();
            Vector<Vector<Integer>> graph = new Vector<Vector<Integer>>();
            for (int i = 0; i < v; i++) {
                graph.add(new Vector<Integer>());
            }
            for (int y = 0; y < e; y++) {
                graph.elementAt(in.nextInt() - 1).add(in.nextInt() - 1);
            }
            System.out.println(kosaRaju(graph, v));
        }
    }

}
