//Coding Ninjas
//
//Given a NxM matrix containing Uppercase English Alphabets only. Your task is to tell if there is a path in the given matrix which makes the sentence “CODINGNINJA” .
//There is a path from any cell to all its neighbouring cells. A neighbour may share an edge or a corner.
//Input Format :
//Line 1 : Two space separated integers N  and M, where N is number of rows and M is number of columns in the matrix.
//Next N lines : N rows of the matrix. First line of these N line will contain 0th row of matrix, second line will contain 1st row and so on
//Assume input to be 0-indexed based
//Output Format :
//Return 1 if there is a path which makes the sentence “CODINGNINJA” else return 0.
//Constraints :
//1 <= N <= 100
//1 <= M <= 100
//Sample Input :
//2 11
//CXDXNXNXNXA
//XOXIXGXIXJX
//Sample Output :
//1


class index {

    public int r;
    public int c;
}

public class solution {

    public boolean getStr(char[][] graph, boolean[][] visited, String str, int r, int c, int n) {
        if (n == str.length() - 1) {
            return true;
        }
        visited[r][c] = true;
        boolean out = false;
        if (r + 1 < graph.length && graph[r + 1][c] == str.charAt(n + 1) && !visited[r + 1][c]) {
            out = getStr(graph, visited, str, r + 1, c, n + 1);
        }
        if (r - 1 >= 0 && graph[r - 1][c] == str.charAt(n + 1) && !visited[r - 1][c] && !out) {
            out = getStr(graph, visited, str, r - 1, c, n + 1);
        }
        if (c + 1 < graph[r].length && graph[r][c + 1] == str.charAt(n + 1) && !visited[r][c + 1] && !out) {
            out = getStr(graph, visited, str, r, c + 1, n + 1);
        }
        if (c - 1 >= 0 && graph[r][c - 1] == str.charAt(n + 1) && !visited[r][c - 1] && !out) {
            out = getStr(graph, visited, str, r, c - 1, n + 1);
        }
        if (r + 1 < graph.length && c + 1 < graph[r].length && graph[r + 1][c + 1] == str.charAt(n + 1) && !visited[r + 1][c + 1] && !out) {
            out = getStr(graph, visited, str, r + 1, c + 1, n + 1);
        }
        if (r - 1 >= 0 && c - 1 >= 0 && graph[r - 1][c - 1] == str.charAt(n + 1) && !visited[r - 1][c - 1] && !out) {
            out = getStr(graph, visited, str, r - 1, c - 1, n + 1);
        }

        if (r - 1 >= 0 && c + 1 < graph[r].length && graph[r - 1][c + 1] == str.charAt(n + 1) && !visited[r - 1][c + 1] && !out) {
            out = getStr(graph, visited, str, r - 1, c + 1, n + 1);
        }
        if (r + 1 < graph.length && c - 1 >= 0 && graph[r + 1][c - 1] == str.charAt(n + 1) && !visited[r + 1][c - 1] && !out) {
            out = getStr(graph, visited, str, r + 1, c - 1, n + 1);
        }

        visited[r][c] = false;
        return out;
    }

    int solve(String[] graph, int N, int M) {
        // Write your code here.
        String str = "CODINGNINJA";
        char[][] graph2 = new char[N][M];
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < graph2.length; i++) {
            graph2[i] = graph[i].toCharArray();
        }
        int count = 0;
        for (int i = 0; i < graph2.length; i++) {
            for (int j = 0; j < graph2[0].length; j++) {
                if (graph2[i][j] == 'C') {
                    if (getStr(graph2, visited, str, i, j, 0)) {
                        count++;
                    }

                }
            }
        }
        return count;
    }
}
