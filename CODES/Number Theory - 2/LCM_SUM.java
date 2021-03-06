//LCM SUM
//
//Given n, calculate and print the sum :
//LCM(1,n) + LCM(2,n) + .. + LCM(n,n)
//where LCM(i,n) denotes the Least Common Multiple of the integers i and n.
//Input Format :
//Line 1 : Integer n
//Output Format :
//Required sum
//Constraints :
//1 <= T <= 300000
//1 <= n <= 1000000
//Sample Input 1 :
//5
//Sample Output 1 :
//55
//Sample Input 2 :
//2
//Sample Output 2 :
//4


#include<bits/stdc++.h>
#define ll long long 
#define f(i,n) for(int i=0;i<n;i++) 
#define fr(i,a,b) for(int i=a;i<b;i++) 
#define F first 
#define S second 
#define mp make_pair 
#define pb push_back 

using namespace std;

ll res[1000001];
ll phi[1000001];

void pre(){
	f(i,1000001)phi[i]=i;
	for(int i=2;i<=1000000;i++){
		if(phi[i]==i){
			for(int j=i;j<=1000000;j=j+i){
				phi[j] = phi[j] - phi[j]/i;
			}
		}
	}
	
	for(int i=1;i<=1000000;i++){
		for(int j=i;j<=1000000;j=j+i){
			res[j]+=(i*phi[i]);
		}
	}
	
}

void test(){
	ll n;
	cin>>n;
	ll x = res[n];
	x++;
	x = x*n;
	x = x/2;
	cout<<x<<"\n";
}

void func(long long n)
{
 	pre();   
   ll x = res[n];
	x++;
	x = x*n;
	x = x/2;
	cout<<x<<"\n";
	// Write your code here
}
