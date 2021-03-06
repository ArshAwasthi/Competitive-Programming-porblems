//Innocent Swaps and His Emotions
//
//There are only three phases in Swaps life: Sleep, Play and Study. Also, there are two types of emotions Swaps experiences: Happy and Sad. Each phase of his life brings either kind of emotions.
//The sleep and the play phase makes Swaps happy whereas the study phase makes him sad. Quite obvious, isn't it? But we know that life isn't that great, one cannot be happy all the time.
//Swaps, being a very sensitive guy, doesn't like to mix his emotions in a particular day. So each day, he is in exactly one of the three phases.
//Given N which denotes the number of days and K which denotes the exact number of days Swaps needs to be happy out of these N days, can you tell him in how many ways can he achieve this? Since the output value can be very large, take modulo with 1000000007(10^9+7)
//Input:
//The first line of the input contains T, denoting the number of test cases.
//
//The next T lines contain two space-separated integers N and K.
//Output:
//For each test-case, output a single integer, the number of ways modulo 1000000007(10^9+7).
//Constraints:
//1 ≤ T ≤ 10^5
//1 ≤ N ≤ 10^6
//1 ≤ K ≤ 10^6
//K ≤ N
//Sample Input :
//3
//1 1
//2 1
//3 2
//Sample Output:
//2
//4
//12
//Explanation
//In the first test case, he needs to be happy on Day 1. Hence, answer is 2 (He can either play or sleep).
//
//In the second test case, he can be happy either on Day 1 or Day 2. So number of ways = 4.



#include <stdio.h>
#define N 1000006
typedef long long ll;
const int M = 1e9 + 7;
ll F[N],Fi[N],p2[N];
long long modulo(long long a,long long b,long long c){
long long x=1,y=a; // long long is taken to avoid overflow of intermediate results
while(b > 0){
if(b%2 == 1){
x=(x*y)%c;
}
y = (y*y)%c; // squaring the base
b /= 2;
}
return x%c;
}
void pre()
{   
    int i;
    F[0] = p2[0] = 1; 
    for(i=1;i<N;i++){
        F[i] = F[i - 1] * i % M;
        p2[i] = p2[i - 1] * 2 % M;
    }
    i=1000000;
    Fi[i] = modulo(F[i],M-2,M);
    for(i--;i>=0;i--){
        Fi[i] = Fi[i + 1] * (i + 1) % M;
    }
    
}
ll C(ll n,ll k){
    ll res;
    res = F[n] * Fi[k] % M;
    res = res * Fi[n - k] % M;
    return res;
}
int main()
{
    int T,i,j;
    scanf("%d",&T);
    pre();
    while(T--)
    {
        ll n,k;
        scanf("%lld %lld",&n,&k);
        printf("%lld\n",C(n,k) * p2[k] % M);
    }
    return 0;
}