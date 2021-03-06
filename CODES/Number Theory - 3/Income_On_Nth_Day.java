//Income On Nth Day
//
//Daulat Ram is an affluent business man. After demonetization, IT raid was held at his accommodation in which all his money was seized. He is very eager to gain his money back, he started investing in certain ventures and earned out of them. On the first day, his income was Rs. X, followed by Rs. Y on the second day. Daulat Ram observed his growth as a function and wanted to calculate his income on the Nth day.
//The function he found out was FN = FN-1 + FN-2 + FN-1×FN-2
//Given his income on day 0 and day 1, calculate his income on the Nth day (yeah Its that simple).
//Input:
//The first line of input consists of a single integer T denoting number of test cases.
//
//Each of the next T lines consists of three integers F0, F1 and N respectively.
//Output:
//For each test case, print a single integer FN, as the output can be large, calculate the answer modulo 10^9+7.
//CONSTRAINTS:
//1 ≤ T ≤ 10^5
//
//0 ≤ F0, F1, N ≤ 10^9
//Sample Input :
//2
//0 1 2
//1 2 4
//Sample Output:
//1
//107
//Explanation
//In the second test case his income on day 0 is 1 and the income on day 1 is 2. We need to calculate his income on day 4.
//
//F0=1
//
//F1=2
//
//F2=1 + 2 + 1×2 = 5
//
//F3=2 + 5 + 2×5 = 17
//
//F4=5 + 17 + 5×17 = 107

import java.util.Scanner;

class Main {

    public static long mod = 1000000007L;

    public static long fib(long n) {
        if (n == 0 || n == 1 || n == 5) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        n--;
        long a[][] = {{1, 1}, {1, 0}};
        long ans[][] = {{1, 0}, {0, 1}};
        long temp[][] = new long[2][2];
        long m = mod - 1;
        while (n > 0) {
            if ((n & 1) > 0) {
//ans=ans*a 
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        temp[i][j] = 0;
                        for (int k = 0; k < 2; k++) {
                            temp[i][j] += a[i][k] * ans[k][j];
                            temp[i][j] %= m;
                        }
                    }
                }
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        ans[i][j] = temp[i][j];
                    }
                }
            }
//a=a*a 
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    temp[i][j] = 0;
                    for (int k = 0; k < 2; k++) {
                        temp[i][j] += a[i][k] * a[k][j];
                        temp[i][j] %= m;
                    }
                }
            }
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    a[i][j] = temp[i][j];
                }
            }
            n >>= 1;
        }
        return ans[0][0];
    }

    public static long mpow(long a, long b) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) > 0) {
                ans = (ans * a) % mod;
            }
            a = (a * a) % mod;
            b >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int a = s.nextInt();
            int b = s.nextInt();
            int n = s.nextInt();
            if (n == 0) {
                System.out.println(a);
            } else if (n == 1) {
                System.out.println(b);
            } else {
                long x = fib(n - 1);
                long y = fib(n);
                long c = mpow(a + 1, x) * mpow(b + 1, y);
                c--;
                c = c % mod;
                if (c < 0) {
                    c += mod;
                }
                System.out.println(c);
            }
        }
    }
}
