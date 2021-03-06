//String Maker
//
//According to Ancient Ninjas , string making is an art form . There are various methods of string making , one of them uses previously generated strings to make the new one . Suppose you have two strings A and B , to generate a new string C , you can pick a subsequence of characters from A and a subsequence of characters from B and then merge these two subsequences to form the new string.
//Though while merging the two subsequences you can not change the relative order of individual subsequences. What this means is - suppose there two characters Ai and Aj in the subsequence chosen from A , where i < j , then after merging if i acquires position k and j acquires p then k<p should be true and the same apply for subsequence from C.
//Given string A , B , C can you count the number of ways to form string C from the two strings A and B by the method described above. Two ways are different if any of the chosen subsequence is different .
//As the answer could be large so return it after modulo 10^9+7 .
//Input Format :
//Line 1 : String A
//Line 2 : String B
//Line 3 : String C
//Output Format :
//The number of ways to form string C
//Constraints :
//1 <= |A|, |B|, |C| <= 50
//Sample Input :
//abc
//abc 
//abc
//Sample Output :
//8

public class Solution {

    static String A, B, C;
    static int[][][] DP = new int[55][55][55];
    static int MOD = 1000000007;

    private static int solver(int x, int y, int z) {
        if (z == 0) //string C is complete 
        {
            return 1;
        }
        if ((x <= 0 && y <= 0)) {
            return 0;
        }
        if (DP[x][y][z] != -1) {
            return DP[x][y][z];
        }
        int ways = 0;
        for (int i = x - 1; i >= 0; i--) // pick the zth char from A
        {
            if (A.charAt(i) == C.charAt(z - 1)) {
                ways = (ways + solver(i, y, z - 1)) % MOD;
            }
        }
        for (int i = y - 1; i >= 0; i--) // pick the zth char from B
        {
            if (B.charAt(i) == C.charAt(z - 1)) {
                ways = (ways + solver(x, i, z - 1)) % MOD;
            }
        }
        return DP[x][y][z] = ways;
    }

    public static int solve(String a, String b, String c) {
        A = a;
        B = b;
        C = c;
        for (int i = 0; i < 52; i++) {
            for (int j = 0; j < 52; j++) {
                for (int k = 0; k < 52; k++) {
                    DP[i][j][k] = -1;
                }
            }
        }
        return solver(a.length(), b.length(), c.length());
    }
}
