//Horrible Queries
//
//World is getting more evil and it's getting tougher to get into the Evil League of Evil. Since the legendary Bad Horse has retired, now you have to correctly answer the evil questions of Dr. Horrible, who has a PhD in horribleness (but not in Computer Science). You are given an array of N elements, which are initially all 0. After that you will be given C commands. They are -
//0 p q v - you have to add v to all numbers in the range of p to q (inclusive), where p and q are two indexes of the array.
//
//1 p q - output a line containing a single integer which is the sum of all the array elements between p and q (inclusive)
//Input
//In the first line you'll be given T, number of test cases.
//
//Each test case will start with N (N <= 100 000) and C (C <= 100 000). After that you'll be given C commands in the format as mentioned above. 1 <= p, q <= N and 1 <= v <= 10^7.
//Output
//Print the answers of the queries.
//Input:
//1
//8 6
//0 2 4 26
//0 4 8 80
//0 4 5 20
//1 8 8 
//0 5 7 14
//1 4 8
//Output:
//80  
//508


#include<stdio.h>
#include<algorithm>
#include<iostream>
#include<string.h>
#include<queue>
#include<stack>
#include<map>
#include<math.h>
using namespace std;
typedef long long LL;
LL tree[6*100005];
LL cnt[6*100005];
LL aa[100005];
void down(int k);
void up(int k,int v);
LL  ask(int l,int r,int k,int n,int m);
void  in(int l,int r,int k,int n,int m,int u);
int main(void)
{
        int i,j,k;
        scanf("%d",&k);
        int s;
        int n,m;
        for(s=1; s<=k; s++)
        {
                scanf("%d %d",&n,&m);
                memset(tree,0,sizeof(tree));
                memset(cnt,0,sizeof(cnt));
                int flag=0;
                while(m--)
                {
                        int x,y;
                        int xx,yy,zz;
                        scanf("%d",&x);
                        if(x==0)
                        {
                                scanf("%d %d %d",&xx,&yy,&zz);
                                in(xx,yy,0,0,n-1,zz);
                        }
                        else
                        {
                                scanf("%d %d",&xx,&yy);
                                LL as=ask(xx,yy,0,0,n-1);
                                aa[flag++]=as;
                        }

                }
                for(i=0; i<flag; i++)
                        printf("%lld\n",aa[i]);
        }
}
void down(int k)
{
        cnt[2*k+1]+=cnt[k];
        cnt[2*k+2]+=cnt[k];
        cnt[k]=0;
}
void up(int k,int v)
{
        int cc=k;
        tree[cc]+=cnt[k]*v;
        if(cc==0)return ;
        while(cc>=0)
        {
                cc=(cc-1)/2;
                tree[cc]=tree[2*cc+1]+tree[2*cc+2];
                if(cc==0)
                        return ;
        }
}
LL  ask(int l,int r,int k,int n,int m)
{
        if(l>m||r<n)
        {
                if(cnt[k]>0)
                {
                        up(k,m-n+1);
                        down(k);
                }
                return 0;
        }
        else if(l<=n&&r>=m)
        {
                if(cnt[k]>0)
                {
                        up(k,m-n+1);
                        down(k);
                        return tree[k];
                }
                else return tree[k];
        }
        else
        {
                if(cnt[k]>0)
                {

                        down(k);
                }
                LL nx=ask(l,r,2*k+1,n,(n+m)/2);
                LL ny=ask(l,r,2*k+2,(n+m)/2+1,m);
                return nx+ny;
        }
}
void  in(int l,int r,int k,int n,int m,int u)
{
        if(l>m||r<n)
        {
                if(cnt[k]>0)
                {
                        up(k,m-n+1);
                        down(k);
                }
                return ;
        }
        else if(l<=n&&r>=m)
        {
                cnt[k]+=u;
                up(k,m-n+1);
                down(k);
                return ;
        }
        else
        {
                if(cnt[k]>0)
                {

                        down(k);
                }
                in(l,r,2*k+1,n,(n+m)/2,u);
                in(l,r,2*k+2,(n+m)/2+1,m,u);
        }
}