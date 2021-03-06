//Fibonacci Sum
//
//The fibonacci sequence is defined by the following relation:
// F(0) = 0
// F(1) = 1
// F(N) = F(N - 1) + F(N - 2), N >= 2
//Your task is very simple. Given two non-negative integers N and M (N <= M), you have to calculate and return the sum (F(N) + F(N + 1) + ... + F(M)) mod 1000000007.
//Input Format :
//Two non-negative integers N and M. (N <= M)
//Output Format :
//A single line containing the answer for the task.
//Sample Input :
//10 
//19
//Sample Output :
//10857



#include <iostream>
using namespace std;
#define num 1000000007
 
 long long int fibo(int x){
     int a=0,b=1,c;
     for(int i=1;i<=x;i++){
         c=(a+b)%num;
         b=a%num;
         a=c;
     }
    return a%num; 
 }

	    


unsigned long long fiboSum(unsigned long long m,unsigned long long n)
{
	// Write your code here
    int temp;
	    long long int sum=0;
    int x=m,y=n;
	    m=0,n=0;
	    if(x==y){
	        m=fibo(x);
	        sum=m%num;
	    }
	    else
	     { 
	         m=fibo(x);
	         n=fibo(x+1);
	         sum=(m+n)%num;
	     }
	     for(int j=x+2;j<=y;j++){
	       sum=sum%num + (m+n)%num;
	       temp=(m+n)%num;
	       m=n;n=temp;
	                             }
	    return sum%num;
}

