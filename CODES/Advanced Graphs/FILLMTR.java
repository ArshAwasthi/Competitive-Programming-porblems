//FILLMTR
//
//Fill The Matrix
//A matrix B (consisting of integers) of dimension N × N is said to be good if there exists an array A (consisting of integers) such that B[i][j] = |A[i] - A[j]|, where |x| denotes absolute value of integer x.
//
//You are given a partially filled matrix B of dimension N × N. Q of the entries of this matrix are filled by either 0 or 1. You have to identify whether it is possible to fill the remaining entries of matrix B (the entries can be filled by any integer, not necessarily by 0 or 1) such that the resulting fully filled matrix B is good.
//Input
//The first line of the input contains an integer T denoting the number of test cases.
//
//The first line of each test case contains two space separated integers N, Q.
//
//Each of the next Q lines contain three space separated integers i, j, val, which means that B[i][j] is filled with value val.
//Output
//For each test case, output "yes" or "no" (without quotes) in a single line corresponding to the answer of the problem.
//Constraints
//1 ≤ T ≤ 10^6
//2 ≤ N ≤ 10^5
//1 ≤ Q ≤ 10^6
//1 ≤ i, j ≤ N
//0 ≤ val ≤ 1
//Sum of each of N, Q over all test cases doesn't exceed 106
//Input
//4
//2 2
//1 1 0
//1 2 1
//2 3
//1 1 0
//1 2 1
//2 1 0
//3 2
//2 2 0
//2 3 1
//3 3
//1 2 1
//2 3 1
//1 3 1
//Output
//yes
//no
//yes
//no


#include<math.h>
#include<string.h>
#include<bits/stdc++.h>
#include<iostream>
#include<stdio.h>
#define mod(t) ((t)>0?(t):(-(t)))
#define MAXG(t,y) ((t)>(y)?(t):(y))
#define MING(t,y) ((t)<(y)?(t):(y))
#define taked(t) scanf("%d",&t)
#define takellu(t) scanf("%llu",&t)
#define takell(t) scanf("%lld",&t)
#define takes(t) scanf("%s",t)
#define shint unsigned short int
#define llu unsigned long long
#define ll long long
#define MOD 1000000007
using namespace std;
class toValue{public:int to,val;};
int iterated[100001],mark;
vector<toValue> matlow[100001];
int scene1[100001],scene2[100001];

class Q{
	int t,n,a[100001],v[100001],temp,l;
	public:
	Q(){reset();}
	
	void reset(){t=-1;n=0;l=0;}
	
	int top(int &val){
		if(n==0) return 0;
		n--;temp=t;
		val=v[temp];
		if(n==0) {reset();}
		else (++t)%=100001;
		
		return a[temp];
	}
	
	void insert(int k,int val) {
		if(n==0) t=0;
		a[l]=k;
		v[l++]=val;
		l%=100001;
		n++;
		//cout<<n<<endl;
	}
	
	bool isFilled(){return (bool)n;}
}Qu;

void runFor(int pos,int where){
	
	int l=matlow[pos].size(),j,val;
	if(iterated[pos]==2) return;
	iterated[pos]=2;
	for(int i=0;i<l;i++){
		j=matlow[pos][i].to;val=matlow[pos][i].val+1;
		switch(where){
			case 1:
				if(val==1) {
					if((scene1[j]&&scene1[j]==2)||(scene2[j]&&scene2[j]==1)) {mark=0;return ;}
					scene1[j]=1;
					if(!iterated[j]) {Qu.insert(j,1);iterated[j]=1;}
				}
				else{
					if((scene1[j]&&scene1[j]==1)||(scene2[j]&&scene2[j]==2)) {mark=0;return ;}
					scene1[j]=2;
					if(!iterated[j]) {Qu.insert(j,2);iterated[j]=1;}
				}
				break;
			case 2:
				if(val==1) {
					if((scene2[j]&&scene2[j]==2)||(scene1[j]&&scene1[j]==1)) {mark=0;return ;}
					scene2[j]=1;
					if(!iterated[j]) {Qu.insert(j,2);iterated[j]=1;}
					
				}
				else{
					if((scene2[j]&&scene2[j]==1)||(scene1[j]&&scene1[j]==2)) {mark=0;return ;}
					scene2[j]=2;
					if(!iterated[j]) {Qu.insert(j,1);iterated[j]=1;}
				}
				break;
		}
	}
}

int main(){
	int i,t,ii,one,two,s1,s2,pos,v,x,y,n,m;
	taked(t);
	while(t--){
		Qu.reset();
		taked(n);taked(m);
		bzero(iterated,4*(n+1));
		bzero(scene1,4*(n+1));bzero(scene2,4*(n+1));
		i=1;while(i<=n) matlow[i++].clear();
		mark=1;
		
		while(m--) {
			taked(x);taked(y);taked(v);
			if(x==y){
				if(v==1) mark=0;
				continue;
			}
			matlow[x].push_back({y,v});
			matlow[y].push_back({x,v});
		}
		
		i=1;while(mark&&i<=n){
			while(Qu.isFilled()) {
				pos=Qu.top(v);
				runFor(pos,v);
			}
			pos=i++;v=1;
			if(iterated[pos]<2)
			runFor(pos,v);
		}
		
		long long int a[200];
for(long int ccc=0;ccc<=100*n;ccc++)
		{	
		}
		if(mark) printf("yes\n");
		else printf("no\n");
	}
}