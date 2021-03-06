//KQUERY
//
//Given a sequence of n numbers a1, a2, ..., an and a number of k- queries. A k-query is a triple (i, j, k) (1 ≤ i ≤ j ≤ n). For each k-query (i, j, k), you have to return the number of elements greater than k in the subsequence ai, ai+1, ..., aj.
//Input Format
//Line 1: n (1 ≤ n ≤ 30000).
//
//Line 2: n numbers a1, a2, ..., an (1 ≤ ai ≤ 10^9).
//
//Line 3: q (1 ≤ q ≤ 200000), the number of k- queries.
//
//In the next q lines, each line contains 3 numbers i, j, k representing a k-query (1 ≤ i ≤ j ≤ n, 1 ≤ k ≤ 10^9).
//Output Format
//For each k-query (i, j, k), print the number of elements greater than k in the subsequence ai, ai+1, ..., aj in a single line.
//Sample Input
//5
//5 1 2 3 4
//3
//2 4 1
//4 4 4
//1 5 2 
//Sample Output
//2
//0
//3 


#include <bits/stdc++.h>

#define pb push_back
#define all(x) x.begin(),x.end()
#define ms(a,v) memset(a,v,sizeof a)
#define II ({int a; scanf("%d", &a); a;})
#define LL ({Long a; scanf("%lld", &a); a;})
#define DD ({double a; scanf("%lf", &a); a;})
#define ff first
#define ss second
#define mp make_pair
#define gc getchar
#define EPS 1e-10
#define pi 3.1415926535897932384626433832795
using namespace std;

#define FI freopen ("in.txt", "r", stdin)
#define FO freopen ("out.txt", "w", stdout)

typedef long long Long;
typedef unsigned long long ull;
typedef vector<int> vi ;
typedef set<int> si;
typedef vector<Long>vl;
typedef pair<int,int>pii;
typedef pair<string,int>psi;
typedef pair<Long,Long>pll;
typedef pair<double,double>pdd;
typedef vector<pii> vpii;

#define forab(i, a, b)	for (__typeof (b) i = (a) ; i <= b ; ++i)
#define rep(i, n)		forab (i, 0, (n) - 1)
#define For(i, n)		forab (i, 1, n)
#define rofba(i, a, b)	for (__typeof (b)i = (b) ; i >= a ; --i)
#define per(i, n)		rofba (i, 0, (n) - 1)
#define rof(i, n)		rofba (i, 1, n)
#define forstl(i, s)	for (__typeof ((s).end ()) i = (s).begin (); i != (s).end (); ++i)

#define __(args...) {dbg,args; cerr<<endl;}
struct debugger{template<typename T> debugger& operator , (const T& v){cerr<<v<<"\t"; return *this; }}dbg;
#define __1D(a,n) rep(i,n) { if(i) printf(" ") ; cout << a[i] ; }
#define __2D(a,r,c,f) forab(i,f,r-!f){forab(j,f,c-!f){if(j!=f)printf(" ");cout<<a[i][j];}cout<<endl;}

template<class A, class B> ostream &operator<<(ostream& o, const pair<A,B>& p){ return o<<"("<<p.ff<<", "<<p.ss<<")";} //Pair print
template<class T> ostream& operator<<(ostream& o, const vector<T>& v){ o<<"[";forstl(it,v)o<<*it<<", ";return o<<"]";} //Vector print
template<class T> ostream& operator<<(ostream& o, const set<T>& v){ o<<"[";forstl(it,v)o<<*it<<", ";return o<<"]";} //Set print
template<class T> inline void MAX(T &a , T b){ if (a < b ) a = b;}
template<class T> inline void MIN(T &a , T b){ if (a > b ) a = b;}

//Fast Reader
template<class T>inline bool read(T &x){int c=gc();int sgn=1;while(~c&&c<'0'||c>'9'){if(c=='-')sgn=-1;c=gc();}for(x=0;~c&&'0'<=c&&c<='9';c=gc())x=x*10+c-'0';x*=sgn;return ~c;}

enum{ INPUT = 1 , QUERY };

const int MX = 200000 + 7 ;

struct node {
    int st , en , id , typ , val ;
};

int N , Q , tree[MX] , Ans[MX];

bool cmp( node a, node b ) {
    if ( a.val == b.val ) return a.typ > b.typ ;
    return a.val > b.val;
}

void update(int i , int x ) {
    for( ; i <= N ; i += ( i & -i ) ) tree[i] += x ;
}

int S(int i){
    int sum = 0 ;
    for( ; i > 0 ; i -= ( i & -i ) ) sum += tree[i] ;
    return sum ;
}

vector< node > V ;
int main()
{
   // FI ;
    read(N);
    For(i,N){
        node inp ;
        read(inp.val);
        inp.st = inp.en = i;
        inp.typ = INPUT ;
        V.push_back(inp);
    }
    read(Q);
    For(i,Q){
        node inp ;
        read(inp.st) , read(inp.en) , read(inp.val);
        inp.id = i ;
        inp.typ = QUERY ;
        V.push_back(inp);
    }

    sort( all(V) , cmp );
    int SZ = V.size() ;
    rep(i,SZ){
        if( V[i].typ == INPUT ){
            update( V[i].st , 1);
        }else{
            Ans[ V[i].id ] = S( V[i].en ) - S( V[i].st - 1 );
        }
    }
    For(i,Q) printf("%d\n", Ans[i]);
}
