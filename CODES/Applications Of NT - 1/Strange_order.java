//Strange order
//
//Given an integer n . Initially you have permutation p of size n : p[i] = i . To build new array a from p following steps are done while permutation p is not empty:
//Choose maximum existing element in p and define it as x ; Choose all such y in p that gcd ( x , y ) ≠ 1 ; Add all chosen numbers into array a in decreasing order and remove them from permutation. Your task is to find a after p became empty.
//Note: gcd ( a , b ) is the greatest common divisor of integers a and b .
//Input format
//Input contains single integer n ( 1 ≤ n ≤ 2 * 10^6) — the size of permutation p p.
//Output format
//Print n integers — array a .
//Sample Input:
//5
//Sample Output:
//5 4 2 3 1
//Explanation
//It's needed 4 iterations to create array a:
//Add 5
//Add 4 and 2
//Add 3
//Add 1


#include<bits/stdc++.h>
#include<vector>
using namespace std;
 void fastscan(int &x)
    {
        bool neg=false;
        register int c;
        x =0;
        c=getchar();
        if(c=='-')
        {
            neg = true;
            c=getchar();
        }
        for(;(c>47 && c<58);c=getchar())
            x = (x<<1) + (x<<3) +c -48;
        if(neg)
            x *=-1;
    }
int main() {
    // ios_base::sync_with_stdio(false);
    // cin.tie(NULL);
    int n;
    fastscan(n);
    
    int* arr = new int[n+1];
    bool* marked = new bool[n+1];
    
    for(int i=0;i<n+1;i++){
        marked[i] = true;
    }
    
    for(int i=0;i<=n;i++){
        arr[i] = i;
    }
    
    for(int i=2;i*i<=n;i++){
        if(arr[i]==i){
            for(int j=i*i;j<=n;j+=i){
                if(arr[j]==j){
                    arr[j] = i;
                }
            }
        }
    }
    vector<int> v;
    for(int i=n;i>0;i--){
        
        if(marked[i]){
           
            int num = i;
            int prime = arr[i];
            while(num!=1){
                if(num%prime!=0){
                    for(int j=i;j>0;j-=prime){
                        if(marked[j]){
                            v.push_back(j);
                            marked[j] = false;
                            
                        }
                    }
                    prime = arr[num];
                }
                num = num/prime;
            }
            for(int j=i;j>0;j-=prime){
                if(marked[j]){
                    v.push_back(j);
                    marked[j] = false;
                    
                }
            }
        }
        sort(v.begin(),v.end(),greater<int>());
        for(int k=0;k<v.size();k++){
            cout<<v[k]<<" ";
        }
        v.clear();
    }
    delete[] arr;
    delete[] marked;
    return 0;
    
}