//Boring Factorials
//
//Sameer and Arpit want to overcome their fear of Maths and so they have been recently practicing Maths problems a lot. Aman, their friend has been helping them out. But as it goes, Sameer and Arpit have got bored of problems involving factorials. Reason being, the factorials are too easy to calculate in problems as they only require the residue modulo some prime and that is easy to calculate in linear time. So to make things interesting for them, Aman - The Mathemagician, gives them an interesting task. He gives them a prime number P and an integer N close to P, and asks them to find N! modulo P. He asks T such queries.
//Input
//First line contains an integer T, the number of queries asked.
//
//Next T lines contains T queries of the form “N P”. (quotes for clarity)
//Output
//Output exactly T lines, containing N! modulo P.
//Constraints:
//1 <= T <= 1000
//
//1 < P <= 2*10^9
//
//1 <= N <= 2*10^9
//
//Abs(N-P) <= 1000
//Sample Input:
//3
//2 5
//5 11
//21 71
//Sample Output:
//2
//10
//6

import java.util.Scanner;

class Solution {

    public static long pow1(long a, long b, long c) {
        long ans = 1L;
        while (b > 0) {
            if ((b & 1) > 0) {
                ans = (ans * a) % c;
            }
            a = (a * a) % c;
            b = b >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            long fact = 1;
            int n = s.nextInt();
            int p = s.nextInt();
            if (n >= p) {
                System.out.println(0);
                continue;
            }
            for (int i = n + 1; i <= p - 1; i++) {
                fact = (fact * i) % p;
                if (fact == 0) {
                    break;
                }
            }
            long ans = pow1(fact, p - 2, p);
            System.out.println(p - ans);
        }
    }
}
