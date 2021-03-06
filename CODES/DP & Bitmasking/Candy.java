//Candy
//
//Gary is a teacher at XYZ school. To reward his N students he bought a packet of N candies all with different flavours. But the problem is some students like certain flavour while some doesn't. Now Gary wants to know the number of ways he can distribute these N candies to his N students such that every student gets exactly one candy he likes.
//Input Format :
//Line 1 : An integer N (1<= N <= 16) denoting number of students and candies.
//Next N lines : N integers describing the preferences of one student. 1 at i'th (0 <= i < N) position denotes that this student likes i'th candy , 0 means he doesn't.
//Assume input to be 0-indexed based.
//Output Format :
//Return the number of ways Gary can distribute these N candies to his N students such that every student gets exactly one candy he likes.``
//Sample Input:
//3
//1 1 1
//1 1 1
//1 1 1
//Sample Output:
//6


public class solution {

    long solve(int[][] like, int N) {

        //Write your code here.
        int[] dp = new int[1 << N];
        dp[0] = 1;
        for (int i = 0; i < (1 << N) - 1; i++) {
            int temp = i;
            int k = 0;
            while (temp > 0) {
                if (temp % 2 == 1) {
                    k++;
                }
                temp /= 2;

            }
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) == 0) {
                    if (like[k][j] == 1) {

                        dp[i | (1 << j)] += dp[i];

                    }
                }
            }
        }
        return dp[(1 << N) - 1];
    }

}
