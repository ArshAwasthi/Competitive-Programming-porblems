//Distinct Query Problem
//
//Given a sequence of n numbers a1, a2, ..., an and a number of d-queries. A d-query is a pair (i, j) (1 ≤ i ≤ j ≤ n). For each d-query (i, j), you have to return the number of distinct elements in the subsequence ai, ai+1, ..., aj.
//Input
//Line 1: n (1 ≤ n ≤ 30000).
//Line 2: n numbers a1, a2, ..., an (1 ≤ ai ≤ 10^6).
//Line 3: q (1 ≤ q ≤ 200000), the number of d-queries.
//In the next q lines, each line contains 2 numbers i, j representing a d-query (1 ≤ i ≤ j ≤ n).
//Output
//For each d-query (i, j), print the number of distinct elements in the subsequence ai, ai+1, ..., aj in a single line.
//Sample Input
//5
//1 1 2 1 3
//3
//1 5
//2 4
//3 5
//Sample Output
//3
//2
//3 


#include<bits/stdc++.h>
using namespace std;

struct coder
{
	int first,second,index;
}query[200000];

bool operator < (coder A, coder B){
	
	return A.second < B.second;
}

int bit[30001];
void update(int index,int value,int n){

	for(;index<=n;index += index &(-index)){
		bit[index] += value;
	}
}
int last[1000001];
int arr[30001];
int value(int index){

	int res= 0;
	for(;index >0 ;index -= index & (-index)){
		res += bit[index];
	}
	return res;
}

int main(){
	int n;
	cin >> n;

	
	for(int i=1;i<=n;i++){
		cin >> arr[i];
	}

	int q;
	cin>>q;
	
	for(int i=0;i<q;i++){
		cin>>query[i].first>>query[i].second;
		query[i].index = i;
	}

	sort(query,query+q);
	


	memset(last,-1,sizeof(last));



	int k=0;
	int ans[q];

	
	int total = 0;
	for(int i=1;i<=n;i++){
		
		
		if(last[arr[i]] != -1){
			update(last[arr[i]],-1,n);
		}else{
			total++;
		}

		update(i,1,n);
		last[arr[i]] = i;
	

		while(k<q && query[k].second == i){
			
			ans[query[k].index] = total - value(query[k].first-1);
			k++;

		}
		
	}


	for(int i=0;i<q;i++){
		cout << ans[i] <<endl;
	}
	return 0;
}








//JAVA CODE



import java.util.*;
class query{
    public int start,end,index;
    query(int s,int e,int ind){
        start=s;
        end=e;
        index=ind;
    }
}
class way implements Comparator<query>{
    @Override
    public int compare(query a,query b){
        return a.end-b.end;
    }
}
public class Main {

	public static void update(int[] BIT,int index,int n,boolean action){
        for(;index<=n;index+=(index&(-index))){
            if(action)
                BIT[index]++;
            else
                BIT[index]--;
        }
    }
    public static int query(int[] BIT,int index){
        int sum=0;
        for(;index>0;index-=(index&(-index)))
            sum+=BIT[index];
        return sum;
    }
	public static void main(String[] args) {
		// Write your code here
		Scanner in=new Scanner(System.in);
        Map<Integer,Integer> map=new HashMap<>();
        int size=in.nextInt();
        int[] arr=new int[size+1];
        int[] BIT=new int[size+1];
        for(int i=1;i<=size;i++)
            arr[i]=in.nextInt();
        int queries=in.nextInt();
        query[] q=new query[queries];
        for(int i=0;i<queries;i++)
            q[i]=new query(in.nextInt(),in.nextInt(),i);
        Arrays.sort(q,new way());
        int total=0;
        int j=0;
        int[] ans=new int[queries];
        for(int i=1;i<=size;i++){
        	if(map.containsKey(arr[i])){
                update(BIT,map.get(arr[i]),size,false);
            }else
             total++;
            map.put(arr[i],i);
             update(BIT,i,size,true);
                while(j<queries&&q[j].end==i){
                    ans[q[j].index]=total-query(BIT,q[j].start-1);
                    j++;
                }
        }
        for(int i:ans)
            System.out.println(i);
	}

}





