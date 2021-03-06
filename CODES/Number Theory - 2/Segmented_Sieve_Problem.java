//Segmented Sieve Problem
//
//In this problem you have to print all primes from given interval.
//Input
//t - the number of test cases, then t lines follows. [t <= 150]
//On each line are written two integers L and U separated by a blank. L - lower bound of 
//interval, U - upper bound of interval. [2 <= L < U <= 2147483647] [U-L <= 1000000].
//Output
//For each test case output must contain all primes from interval [L; U] in increasing order.
//Sample Input:
//2
//2 10
//3 7
//Sample Output:
//2
//3
//5
//7
//3
//5
//7 


#include <bits/stdc++.h>
using namespace std;

#define pb push_back
#define ff first
#define ss second
#define mp make_pair
#define memo(a,b) memset(a,b,sizeof(a))
#define INF 1e9
#define EPS 1e-8
#define PI 3.14159265358979323846

typedef long long ll ;
typedef unsigned long long ull ;

char check[100000+10];
ll prime[100000+10] , p = 0 ;
int flag[10000000+10] ;

void sieve()
{
    for(int i=2;i<=100000;i++)
    {
        if(check[i]==NULL)
        {
            prime[p++] = i ;
            for(int j=i+i;j<=100000;j+=i) check[j] = 'N' ;
        }
    }
}

int main()
{

    //freopen("input.txt","r",stdin);
    //freopen("output.txt","w",stdout);
    sieve();
    int T ;
    scanf("%d",&T);

    for(int cas=1;cas<=T;cas++)
    {
        ll a , b ;
        scanf("%lld%lld",&a,&b);

        for(int i=0;i<p;i++)
        {
            ll mod = a%prime[i] ;
            ll idx = prime[i] - mod ;
            if(mod==0) idx = 0 ;

            for(int j=idx;j<=b-a;j+=prime[i])
            {
                if(a+j!=prime[i])
                {
                    flag[j] = cas ;
                }
            }
        }

        for(int i=0;i<=b-a;i++)
        {
            if(flag[i]!=cas) printf("%d\n",i+a);
        }
    }
    return 0;
}