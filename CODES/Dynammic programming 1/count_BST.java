//Count BSTs
//
//Given an integer N, find and return the count of unique Binary search trees (BSTs) are possible with nodes valued from 1 to N.
//Output count can be very large, so return the count modulo 10^9+7.
//Input Format :
//Integer n 
//Output Format :
//Count of BSTs
//Contraints :
//1<= N <=1000
//Sample Input 1:
//8
//Sample Output 1:
//1430
//Sample Input 2:
//3
//Sample Output 2:
//5


public class Solution {

    public static int countTrees(int numKeys) {
        int mod = (int) (Math.pow(10, 9) + 7);
        int dp[] = new int[numKeys + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= numKeys; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                long res = dp[j] * (1l * dp[i - j - 1]);
                int temp = (int) (res % mod);
                dp[i] = (dp[i] + temp) % mod;
            }
        }
        return dp[numKeys] % mod;
    }
}
