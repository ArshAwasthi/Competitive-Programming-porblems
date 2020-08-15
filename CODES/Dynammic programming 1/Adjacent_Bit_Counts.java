//Adjacent Bit Counts
//
//For a string of n bits x1,x2,x3,...,Xn the adjacent bit count of the string (AdjBC(x)) is given by
//X1*X2 + X2*X3 + X3*X4 + ... + Xn-1 * Xn
//which counts the number of times a 1 bit is adjacent to another 1 bit. For example:
//AdjBC(011101101) = 3
//AdjBC(111101101) = 4
//AdjBC(010101010) = 0
//Write a program which takes as input integers n and k and returns the number of bit strings x of n bits (out of 2n) that satisfy AdjBC(x) = k. For example, for 5 bit strings, there are 6 ways of getting AdjBC(x) = 2:
//11100, 01110, 00111, 10111, 11101, 11011
//Input
//The first line of input contains a single integer P, (1 = P = 1000), which is the number of data sets that follow. Each data set is a single line that contains the data set number, followed by a space, followed by a decimal integer giving the number (n) of bits in the bit strings, followed by a single space, followed by a decimal integer (k) giving the desired adjacent bit count. The number of bits (n) will not be greater than 100.
//Output
//For each data set there is one line of output. It contains the data set number followed by a single space, followed by the number of n-bit strings with adjacent bit count equal to k. As answer can be very large print your answer modulo 10^9+7.
//Sample Input
//10
//1 5 2
//2 20 8
//3 30 17
//4 40 24
//5 50 37
//6 60 52
//7 70 59
//8 80 73
//9 90 84
//10 100 90
//Sample Output
//1 6
//2 63426
//3 1861225
//4 168212501
//5 44874764
//6 160916
//7 22937308
//8 99167
//9 15476
//10 23076518


import java.util.*;
import java.math.*;

public class Main {
public static int mod=(int)Math.pow(10,9)+7;
	public static int solve(int n,int k,int first,int[][][]dp){
        if(n==1)
        {
            
            if(k==0)
                return 1;
            return 0;
        }
        if(n<=0||k<0)
                return 0;
        if(dp[first][k][n]>-1)
            return dp[first][k][n];
        if(first==1){
            int out=(solve(n-1,k-1,1,dp)+solve(n-1,k,0,dp))%mod;
            dp[first][k][n]=out;
            return out;
        }
        else{
             int out=(solve(n-1,k,1,dp)+solve(n-1,k,0,dp))%mod;
        	 dp[first][k][n]=out;
            return out;
        }
    }
	public static void main(String[] args) {
		// Write your code here
		Scanner in=new Scanner(System.in);
        int cases=in.nextInt();
        for(int x=0;x<cases;x++){
            int setno=in.nextInt();
            int bits=in.nextInt();
            int bitcount=in.nextInt();
            int[][][] arr=new int[2][bitcount+1][bits+1];
            for(int i=0;i<2;i++){
                for(int j=0;j<arr[i].length;j++)
                    Arrays.fill(arr[i][j],0,arr[i][j].length,-1);
            }
            int output=(solve(bits,bitcount,0,arr)+solve(bits,bitcount,1,arr))%mod;
            System.out.println(setno+" "+output);
        }
	}

}