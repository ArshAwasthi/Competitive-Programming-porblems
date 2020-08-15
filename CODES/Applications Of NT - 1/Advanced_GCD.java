//Advanced GCD
//
//Varun explained its friend Sanchit the algorithm of Euclides to calculate the GCD of two numbers. Then Sanchit implements the algorithm
//int gcd(int a, int b)
//{
//
//    if (b==0)
//    return a;
//    else
//    return gcd(b,a%b);
//}
//and challenges to Varun to calculate gcd of two integers, one is a little integer and other integer has 250 digits.
//Your task is to help Varun an efficient code for the challenge of Sanchit.
//Input
//The first line of the input file contains a number representing the number of lines to follow. Each line consists of two number A and B (0 <= A <= 40000 and A <= B < 10^250).
//Output
//Print for each pair (A,B) in the input one integer representing the GCD of A and B..
//Sample Input:
//2
//2 6
//10 11
//Sample Output:
//2
//1

import java.util.Scanner;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        // Write your code here
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for (int i = 0; i < cases; i++) {
            BigInteger a = new BigInteger(in.next());
            BigInteger b = new BigInteger(in.next());
            System.out.println(a.gcd(b));
        }
    }

}
