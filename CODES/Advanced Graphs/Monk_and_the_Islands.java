//Monk and the Islands
//
//MONK AND THE ISLAND
//Monk visits the land of Islands. There are a total of N islands numbered from 1 to N. Some pairs of islands are connected to each other by Bidirectional bridges running over water.
//Monk hates to cross these bridges as they require a lot of efforts. He is standing at Island #1 and wants to reach the Island #N. Find the minimum the number of bridges that he shall have to cross, if he takes the optimal route.
//Input:
//First line contains T. T testcases follow.
//First line of each test case contains two space-separated integers N, M.
//Each of the next M lines contains two space-separated integers X and Y , denoting that there is a bridge between Island X and Island Y.
//Output:
//Print the answer to each test case in a new line.
//Constraints:
//1 ≤ T ≤ 10
//1 ≤ N ≤ 10000
//1 ≤ M ≤ 100000
//1 ≤ X, Y ≤ N
//SAMPLE INPUT
//2
//3 2
//1 2
//2 3
//4 4
//1 2
//2 3
//3 4
//4 2
//SAMPLE OUTPUT
//2
//2


#include<stdio.h>
#include<stdlib.h>
struct Node{
	int v;
	struct Node *next;
};
struct q{
	int h,t,arr[10005];
};
struct Node* add(struct Node *v1,int v2)
{
	struct Node *ptr=(struct Node*)malloc(sizeof(struct Node));
	ptr->v=v2;
	ptr->next=v1;
	return ptr;
}
void enqueue(struct q* q1,int x)
{
	q1->arr[++q1->t]=x;
}
int dequeue(struct q* q1)
{
	return q1->arr[++q1->h];
}
int bfs(struct Node* list[],int n)
{
	int lev[10005]={0};
	int i,vis[10005]={0},u,v,c=0;
	lev[1]=0;
	struct q q1;
	q1.h=q1.t=-1;
	struct Node* p;
	enqueue(&q1,1);
	vis[1]=1;
	while(q1.h!=q1.t)
	{
		u=dequeue(&q1);
		for(p=list[u];p!=NULL;p=p->next)
		{
			v=p->v;
			if(!vis[v])
			{
				lev[v]=lev[u]+1;
				if(v==n)
				{
					c=1;
					break;
				}
				enqueue(&q1,v);
				vis[v]=1;
			}
		}
		if(c==1)
			break;
	}
	return lev[n];
}
int main()
{
	int n,i,v1,v2,t,m;
	scanf("%d",&t);
	while(t--)
	{
		scanf("%d%d",&n,&m);
		struct Node *list[n+1];
		for(i=1;i<=n;i++)
		list[i]=NULL;
		for(i=1;i<=m;i++)
		{
			scanf("%d%d",&v1,&v2);
			list[v1]=add(list[v1],v2);
			list[v2]=add(list[v2],v1);
		}
	printf("%d\n",bfs(list,n));
    }
	return 0;
}