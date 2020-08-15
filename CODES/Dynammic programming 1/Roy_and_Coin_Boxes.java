//Roy and Coin Boxes
//
//Roy has N coin boxes numbered from 1 to N.
//Every day he selects two indices [L,R] and adds 1 coin to each coin box starting from L to R (both inclusive).
//He does this for M number of days.
//
//After M days, Roy has a query: How many coin boxes have atleast X coins.
//He has Q such queries.
//Input
//First line contains N - number of coin boxes.
//Second line contains M - number of days. Each of the next M lines consists of two space separated integers L and R. Followed by integer Q - number of queries.
//Each of next Q lines contain a single integer X.a
//Output
//For each query output the result in a new line.
//Constraints
//1 = N = 1000000
//
//1 = M = 1000000
//
//1 = L = R = N
//
//1 = Q = 1000000
//
//1 = X = N
//Sample Input
//7
//4
//1 3
//2 5
//1 2
//5 6
//4
//1
//7
//4
//2
//Sample Output
//6
//0
//0
//4



import java.io.IOException;
import java.util.*;

public class Main {

    static FasterScanner in = new FasterScanner();
    static long[] days = new long[1000001];
    static long[] strt = new long[1000001];
    static long[] en = new long[1000001];
    static long[] ans = new long[1000001];

    public static void main(String[] args) throws Exception {
        long n, m, x, q, l, r, i, c = 0;
        n = in.nextLong();
        m = in.nextLong();
        for (i = 0; i < m; i++) {
            l = in.nextInt();
            r = in.nextInt();
            strt[(int) l]++;
//noting the times the starting box was kth box 
        en[(int)r]++;
//noting the times the ending box was kth box 
        }
        for (i = 1; i <= n; i++) {
            c += strt[(int) i];
            days[(int) i] = c;
//number of coins in a box is same as number of days the coin was put in the box 
            c -= en[(int) i];
        }
//now calculate how many boxes have exact i coins 
        for (i = 1; i <= n; i++) {
            ans[(int) days[(int) i]]++;
        }
        /*now calculate how many boxes have atleast i coins which is same as number of boxes having atleast i+1 coins + number of boxes having exact i coins Note: box with atleast max coins is same as box with exact k coins In other words we can take max as n and start iterating from n-1*/
        for (i = n - 1; i > 0; i--) {
            ans[(int) i] = ans[(int) i] + ans[(int) i + 1];
        }
        q = in.nextLong();
        while (q-- > 0) {
            c = 0;
            x = in.nextLong();
            System.out.println(ans[(int) x]);
        }
    }

    static class FasterScanner {

        private byte[] buf = new byte[1024];
        private int curChar;
        private int snumChars;

        public int read() {
            if (snumChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = System.in.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public String nextLine() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

        public long[] nextLongArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
    }
}
