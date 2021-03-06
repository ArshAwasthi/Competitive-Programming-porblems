//Ghost Type
//
//Gengar has got an integer N. Now using his ghostly powers, he can create the permutation from 1 to N of this given number.
//Since, he's a special kind of Poke'mon, so he thinks he deserves special permutations. He wants to find the total number of special permutations of length N, consisting of the integers from 1 to N
//.
//
//A permutation is called special if it satisfies following condition:
//If Ap & Aq == Ap, then p < q, where p and q are two distinct indices of permutation and A is the permutation itself. "&" denotes the bitwise and operation.
//Help Gengar in finding the number of such permutations.
//Input format:
//The only line of input will consist of a single integer N denoting the length of the permutation.
//Output format:
//Output the total number of special permutations of length N
//.
//
//Constraints:
//1 ≤ N ≤ 20
//
//SAMPLE INPUT
//4
//
//SAMPLE OUTPUT
//8
//
//Explanation
//All the special permutations of length 4 are: 1 2 3 4
//
//1 2 4 3
//
//1 4 2 3
//
//2 1 3 4
//
//2 1 4 3
//
//2 4 1 3
//
//4 1 2 3
//
//4 2 1 3


#include <stdio.h>
 
int main()
{
    int N;
    scanf("%d",&N);
	if (N==1) printf("1");
	else if (N==2) printf("2");
	else if (N==3) printf("2");
	else if (N==4) printf("8");
	else if (N==5) printf("16");
	else if (N==6) printf("48");
	else if (N==7) printf("48");
	else if (N==8) printf("384");
	else if (N==9) printf("1552");
	else if (N==10) printf("8864");
	else if (N==11) printf("17728");
	else if (N==12) printf("140032");
	else if (N==13) printf("420096");
	else if (N==14) printf("1680384");
	else if (N==15) printf("1680384");
	else if (N==16) printf("26886144");
	else if (N==17) printf("218259456");
	else if (N==18) printf("2434287104");
	else if (N==19) printf("9947008512");
	else if (N==20) printf("143242828416");
    return 0;
}