//Surveyor
//
//A plot has been surveyed. Its boundary consists of segments that form a polygon. Each segment runs either North-South or East-West. Calculate the enclosed area.
//The i-th character of direction and the i-th element of length describe the direction and length of the i-th segment of the polygon's boundary as the surveyor walked it. If you start at the surveyor's starting point and walk according to the sequence of directions and lengths reported by the surveyor, you will traverse the boundary of the polygon, ending up back at the starting point. This traversal described by the given segments may be either clockwise or counterclockwise.
//Input Format
//String s
//Array of length of string
//Output Format
//Area
//Constraints
//direction will have between 4 and 50 characters inclusive.
//length will have the same number of elements as the number of characters in direction.
//Each element of direction will be an uppercase letter 'N', 'E', 'S', or 'W'.
//Each element of length will be between 1 and 1000 inclusive.
//The segments will represent a simple polygon. No two segments will touch or intersect (except that the last point of a segment is the first point of the next segment, and the last point of the final segment is the first point of the first segment).
//Sample Test Case
//"NWWSE"
//{10,3,7,10,10}
//Returns: 100
//
//
//"NESWNWSW"
//{20,200,30,100,20,30,10,70}
//Returns: 4700


#include<bits/stdc++.h>
using namespace std;
 
#define input(arr,n)        for(ll i=0; i<n; i++) {cin>>arr[i];}
#define pb(a)               push_back(a)
#define mp(a,b)             make_pair(a,b)
#define SIZE5               100005
#define SIZE6               1000006
#define SIZE7               10000007
 
typedef long long int ll;
 
const ll MOD = 1000000007;
const ll MAXN = 100005;
 
ll X[MAXN], Y[MAXN];
ll fans = 0;
 
ll shoelace(ll n) 
{ 
    ll area = 0;
    
    ll j = n-1; 
    for(ll i=0; i<n; i++) 
    { 
        area += (X[j] + X[i]) * (Y[j] - Y[i]); 
        j = i;  
    } 
    return abs(area / 2.0); 
}
 
int main()
{
    ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
 
    string S;
    cin >> S;
    
    
    ll arr[S.length()];
    for(ll i=0; i<S.length(); i++) cin >> arr[i];
    
    ll x= 0, y = 0;
    
    
    
    X[0] = 0;
    Y[0] = 0;
    
    for(int i=0; i<S.length(); i++)
    {
        if(S[i] == 'N')
        {
            y += arr[i];
        }
        else if(S[i] == 'S')
        {
            y -= arr[i];
        }
        else if(S[i] == 'W')
        {
            x += arr[i];
        }
        else if(S[i] == 'E')
        {
            x -= arr[i];
        }
        
        X[i+1] = x;
        Y[i+1] = y;
    }
    
    fans = shoelace(S.length());
    cout << fans << endl;
    
    
    return 0;
}