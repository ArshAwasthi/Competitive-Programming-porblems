//2 vs 3
//
//The fight for the best number in the globe is going to finally come to an end.The top two contenders for the best number are number 2 and number 3.It's the final the entire world was waiting for. Expectorates from all across the globe came to witness the breath taking finals.
//The finals began in an astonishing way.A common problem was set for both of them which included both these number.The problem goes like this.
//Given a binary string (that is a string consisting of only 0 and 1). They were supposed to perform two types of query on the string.
//Type 0: Given two indices l and r.Print the value of the binary string from l to r modulo 3.
//
//Type 1: Given an index l flip the value of that index if and only if the value at that index is 0.
//The problem proved to be a really tough one for both of them.Hours passed by but neither of them could solve the problem.So both of them wants you to solve this problem and then you get the right to choose the best number in the globe.
//Input:
//The first line contains N denoting the length of the binary string .
//The second line contains the N length binary string.Third line contains the integer Q indicating the number of queries to perform.
//This is followed up by Q lines where each line contains a query.
//Output:
//For each query of Type 0 print the value modulo 3.
//Constraints:
//1<= N <=10^5
//
//1<= Q <= 10^5
//
//0 <= l <= r < N
//Sample Input
//5
//10010
//6
//0 2 4
//0 2 3
//1 1
//0 0 4
//1 1
//0 0 3
//Sample Output
//2
//1
//2
//1

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
 
#define MIN(a,b) (((a)<(b))?(a):(b))
#define MAX(a,b) (((a)>(b))?(a):(b))
#define FI(i,s,n) for(i=s;i<=n;i++)
#define FD(i,n,s) for(i=n;i>=s;i--)
#define MA 1000000000000000000 // 1e18
#define M  1000000007
#define MM 2000000000
#define N  100005
#define K  2
 
typedef long long ll;
typedef long double ld;
 
ll n,m;
ll a[N];
ll b[K][N];
ll c[K];
char s[N];
 
void update(ll k, ll i, ll v) {
  while(i<=n) {
    b[k][i]+=v;
    i+=i&-i;
  }
}
 
ll query(ll k, ll i) {
  ll r=0;
  while(i>0) {
    r+=b[k][i];
    i-=i&-i;
  }
  return r;
}
 
ll find(ll k, ll v) {
  ll l=1, r=c[k], m, ss;
 
  while(l<r) {
    m=(l+r)/2;
 
    ss = query(k, m);
    if (ss > v) {
      r=m-1;
    } else if (ss == v){
      r=m;
    } else {
      l=m+1;
    }
  }
 
  return l;
}
 
int main() {
  ll t;
  ll i,j,k,d,l,r,x,y,p,q;
  char cc;
 
  t=1;

  while(t--) {
    scanf("%lld", &n);
    scanf("%s", s);
 
    memset(b, 0, sizeof(b));
    k=0;
    FD(i,n-1,0) {
      if (s[i]=='1') {
        update(k, i+1, 1);
      }
      k=(k+1)%2;
    }
 
    scanf("%lld", &q);
    FI(i,1,q) {
      scanf("%lld", &p); 
      if (p==1) {
        scanf("%lld", &l);
        k = (n-1-l)%2;
        if (s[l]=='0') {
          s[l]='1';
          update(k, l+1, 1);
        }
      } else {
        scanf("%lld %lld", &l, &r);
        x = query(0, r+1) - query(0, l);
        y = query(1, r+1) - query(1, l);
 
        k = (n-1-r)%2;
        if (k==0) {
          l = x+y*2;
        } else
          l = x*2+y;
 
        printf("%lld\n", l%3);
      }
    }
  }
}