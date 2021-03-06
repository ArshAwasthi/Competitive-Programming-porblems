//Connecting Dots
//
//Gary has a board of size NxM. Each cell in the board is a coloured dot. There exist only 26 colours denoted by uppercase Latin characters (i.e. A,B,...,Z). Now Gary is getting bore and wants to play a game. The key of this game is to find a cycle that contain dots of same colour. Formally, we call a sequence of dots d1, d2, ..., dk a cycle if and only if it meets the following condition:
//1. These k dots are different: if i ≠ j then di is different from dj.
//2. k is at least 4.
//3. All dots belong to the same colour.
//4. For all 1 ≤ i ≤ k - 1: di and di + 1 are adjacent. Also, dk and d1 should also be adjacent. Cells x and y are called adjacent if they share an edge.
//Since Gary is colour blind, he wants your help. Your task is to determine if there exists a cycle on the board.
//Assume input to be 0-indexed based.
//Input Format :
//Line 1 : Two integers N and M, the number of rows and columns of the board
//Next N lines : a string consisting of M characters, expressing colors of dots in each line. Each character is an uppercase Latin letter.
//Output Format :
//Return 1 if there is a cycle else return 0
//Constraints :
//2 ≤ N, M ≤ 50
//Sample Input :
//3 4
//AAAA
//ABCA
//AAAA
//Sample Output :
//1


public class solution {

    boolean cycle(char[][] graph, boolean[][] visited, int r, int c, int n, int sr, int sc) {
        if (c + 1 < graph[0].length && r + 1 < graph.length) {

            char x = graph[r][c];
            if (x == graph[r + 1][c + 1]) {
                if (x == graph[r + 1][c] && x == graph[r][c + 1]) {
                    return true;
                }
            }
        }
        if (r == sr && c == sc && n > 0) {
            return true;
        }
        visited[r][c] = true;
        boolean out = false;
        if (r + 1 < graph.length && graph[r + 1][c] == graph[sr][sc] && !visited[r + 1][c]) {
            out = cycle(graph, visited, r + 1, c, n + 1, sr, sc);
        }

        if ((c + 1 < graph[r].length && graph[r][c + 1] == graph[sr][sc] && !visited[r][c + 1] && !out)) {
            out = cycle(graph, visited, r, c + 1, n + 1, sr, sc);
        }
        if ((r - 1 >= 0 && graph[r - 1][c] == graph[sr][sc] && !visited[r - 1][c] && !out && (r - 1) != sr)) {
            out = cycle(graph, visited, r - 1, c, n + 1, sr, sc);
        }
        if ((c - 1 >= 0 && graph[r][c - 1] == graph[sr][sc] && !visited[r][c - 1] && !out && (c - 1 != sc))) {
            out = cycle(graph, visited, r, c - 1, n + 1, sr, sc);
        }
        visited[r][c] = false;
        return out;
    }

    int solve(String[] board, int n, int m) {
        // Write your code here.
        char[][] graph = new char[n][m];
        for (int i = 0; i < n; i++) {
            graph[i] = board[i].toCharArray();
        }
        if (graph.length == 2 && graph[0].length == 2) {
            if (graph[1][1] != graph[0][0]) {
                return 0;
            }
        }
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (cycle(graph, visited, i, j, 0, i, j)) {
                    return 1;
                }
                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < m; y++) {
                        visited[x][y] = false;
                    }
                }
            }
        }
        return 0;
    }
}
