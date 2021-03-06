//Edges in MST
//
//Edges in MST
//You are given a connected weighted undirected graph without any loops and multiple edges.
//
//Let us remind you that a graph's spanning tree is defined as an acyclic connected subgraph of the given graph that includes all of the graph's vertexes. The weight of a tree is defined as the sum of weights of the edges that the given tree contains. The minimum spanning tree (MST) of a graph is defined as the graph's spanning tree having the minimum possible weight. For any connected graph obviously exists the minimum spanning tree, but in the general case, a graph's minimum spanning tree is not unique.
//
//Your task is to determine the following for each edge of the given graph: whether it is either included in any MST, or included at least in one MST, or not included in any MST.
//Input
//The first line contains two integers n and m (2 ≤ n ≤ 10^5, ) — the number of the graph's vertexes and edges, correspondingly. Then follow m lines, each of them contains three integers — the description of the graph's edges as "ai bi wi" (1 ≤ ai, bi ≤ n, 1 ≤ wi ≤ 10^6, ai ≠ bi), where ai and bi are the numbers of vertexes connected by the i-th edge, wi is the edge's weight. It is guaranteed that the graph is connected and doesn't contain loops or multiple edges.
//Output
//Print m lines — the answers for all edges. If the i-th edge is included in any MST, print "any"; if the i-th edge is included at least in one MST, print "at least one"; if the i-th edge isn't included in any MST, print "none". Print the answers for the edges in the order in which the edges are specified in the input.
//Sample input 1
//4 5
//1 2 101
//1 3 100
//2 3 2
//2 4 2
//3 4 1
//sample output 1
//none
//any
//at least one
//at least one
//any
//Sample input 2
//3 3
//1 2 1
//2 3 1
//1 3 2
//sample output 2
//any
//any
//none
//sample input 3
//3 3
//1 2 1
//2 3 1
//1 3 1
//sample output 3
//at least one
//at least one
//at least one
//Note
//In the second sample the MST is unique for the given graph: it contains two first edges.
//
//In the third sample any two edges form the MST for the given graph.
//That means that each edge is included at least in one MST.



#include<stdio.h>
#include<string.h>
#include<algorithm>
using namespace std;
struct node
{
    int x,y,w,pos;
}a[1250000];
int ans[150000];
int n,m;
int cmp(node a,node b)
{
    return a.w<b.w;
}

struct node2
{
    int from,to,w,next;
}e[1500000];
int cont;
int head[150000];
int vis[150000];
int dfn[150000];
int low[150000];
int fa[150000];
int cnt;
void add(int from,int to,int w)
{
    e[cont].to=to;
    e[cont].w=w;
    e[cont].next=head[from];
    head[from]=cont++;
}
void Dfs(int u,int from)
{
    low[u]=dfn[u]=cnt++,vis[u]=1;
    for(int i=head[u];i!=-1;i=e[i].next)
    {
        int v=e[i].to;
        if(vis[v]==1&&e[i].w!=from)low[u]=min(low[u],dfn[v]);
        else if(!vis[v])
        {
            Dfs(v,e[i].w);
            low[u]=min(low[u],low[v]);
            if(low[v]>dfn[u])ans[e[i].w]=1;
        }
    }
}
int f[1250000];
int find(int a)
{
    int r=a;
    while(f[r]!=r)
    r=f[r];
    int i=a;
    int j;
    while(i!=r)
    {
        j=f[i];
        f[i]=r;
        i=j;
    }
    return r;
}
void merge(int a,int b)
{
    int A,B;
    A=find(a);
    B=find(b);
    if(A!=B)
    {
        head[a]=head[b]=head[A]=head[B]=-1;
        vis[a]=vis[b]=vis[A]=vis[B]=0;
        dfn[a]=dfn[b]=dfn[A]=dfn[B]=0;
        low[a]=low[b]=low[A]=low[B]=0;
        f[B]=A;
    }
}
/****************************/
int main()
{
    while(~scanf("%d%d",&n,&m))
    {
        cont=0;
        cnt=1;
        memset(dfn,0,sizeof(dfn));
        memset(low,0,sizeof(low));
        memset(vis,0,sizeof(vis));
        memset(head,-1,sizeof(head));
        memset(ans,0,sizeof(ans));
        for(int i=1;i<=n;i++)f[i]=i;
        for(int i=1;i<=m;i++)scanf("%d%d%d",&a[i].x,&a[i].y,&a[i].w),a[i].pos=i;
        sort(a+1,a+1+m,cmp);
        for(int i=1;i<=m;i++)
        {
            int ss=i;
            int ee=i;
            while(ee+1<=m&&a[ee].w==a[ee+1].w)ee++;
            for(int j=ss;j<=ee;j++)
            {
                int fx=find(a[j].x);
                int fy=find(a[j].y);
                if(fx!=fy)
                {
                    ans[a[j].pos]=2;
                    add(fx,fy,a[j].pos);
                    add(fy,fx,a[j].pos);
                }
            }
            for(int j=ss;j<=ee;j++)
            {
                int fx=find(a[j].x);
                int fy=find(a[j].y);
                if(fx!=fy&&vis[fx]==0)Dfs(fx,-1);
                if(fx!=fy&&vis[fy]==0)Dfs(fy,-1);
            }
            for(int j=ss;j<=ee;j++)
            {
                merge(a[i=j].x,a[j].y);
            }
            i=ee;
        }
        for(int i=1;i<=m;i++)
        {
            if(ans[i]==0)printf("none\n");
            if(ans[i]==1)printf("any\n");
            if(ans[i]==2)printf("at least one\n");
        }
    }
}

