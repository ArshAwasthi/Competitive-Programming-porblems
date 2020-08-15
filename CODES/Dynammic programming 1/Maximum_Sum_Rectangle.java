//Maximum Sum Rectangle
//
//Given a 2D array, find the maximum sum rectangle in it. In other words find maximum sum over all rectangles in the matrix.
//Input
//First line contains 2 numbers n and m denoting number of rows and number of columns. Next n lines contain m space separated integers denoting elements of matrix nxm.
//Output
//Output a single integer, maximum sum rectangle.
//Constraints
//1<=n,m<=100
//Sample Input
//4 5
//1 2 -1 -4 -20
//-8 -3 4 2 1
//3 8 10 1 3
//-4 -1 1 7 -6
//Sample Output
//29


#include <bits/stdc++.h>
#define mod 1000000007
#define inf 1000000000000LL
#define root2 1.41421
#define root3 1.73205
#define pi 3.14159
#define MAX 100001
#define cntbit __builtin_popcountll
#define ll long long int
#define PII pair<int, int>
#define f first
#define s second
#define mk make_pair #define PLL pair<ll, ll>
#define gc getchar
#define pb push_back
using namespace std;
ll M[101][101];
ll kadane(vector<ll> v) {
    int n=v.size();
    int i, j;
    ll ret=0, me=-inf, csum=0;
    for(i=0; i<n; i++) {
        csum+=v[i];
        if(csum<0)csum=0;
        ret = max(ret, csum);
        me=max(me, v[i]);
    }
    if(me<0)return me;
    else return ret;
}
int main() {
    ll mxsum=-inf, sum, i, j, k, n, m;
    cin>>n>>m;
    for(i=0; i<n; i++) for(j=0; j<m; j++) cin>>M[i][j];
    for(int l=0; l<m; l++) {
        vector<ll> v(n, 0);
        for(int r=l; r<m; r++) {
            for(i=0; i<n; i++) v[i]+=M[i][r];
            mxsum=max(kadane(v), mxsum);
        }
    }
    cout<<mxsum<<endl;
}