//Winning strategy
//
//Our college team is going to the sports fest to play a football match with our coach. There are n players in our team, numbered from 1 to n.
//The coach will know the position of another team hence create a winning strategy. He creates the position of every player in a specific order so that we will win and then he starts swapping two players at a time to form the positions.
//He swaps payers in such a way that it can't be understood by another team:
//1. Any player can swap with the player directly at front him
//2. One player can swap at most with two other players
//If the specific order is formed then our team will win otherwise we will lose
//Input Format
//The First line contains numbers of players in team: n
//The second line contains n space separated integers denoting the specific position of players: i-th integer denotes the position of Ai player in winning strategy
//Output Format
//If our team wins print "YES"(without quotes) and in next line print the minimum numbers of swapping required to form this specific order otherwise print "NO"(without quotes) 
//Constraints
//1 =< n <= 10^5 
//1 <= Ai <= n
//Sample Input1:
//5
//2 1 5 3 4
//Sample Output1:
//YES
//3
//Sample Input2:
//5
//2 5 1 3 4
//Sample Output3:
//NO   
//Explaination
//In the First Sample case, 
//    Initial state: 1 2 3 4 5
//    Three moves required to form this order:
//    1 2 3 4 5 -> 1 2 3 5 4 -> 1 2 5 3 4 -> 2 1 5 3 4
//In the second case, no way to form this specific order


import java.util.*;

public class Main {
    public static int merge(Integer[] arr,int start,int mid,int end,HashMap<Integer,Integer> map){
        Integer[] arr1=Arrays.copyOfRange(arr,start,mid+1);
        Integer[] arr2=Arrays.copyOfRange(arr,mid+1,end+1);
        int k=start;
        int i=0;
        int j=0;
        int swap=0;
        boolean flag=false;
        while(i<arr1.length&&j<arr2.length){
            if(arr1[i]<=arr2[j]){
              
                arr[k++]=arr1[i++];
            }
            else{
                //do calculate swaps
               
                if(map.get(arr2[j])>=2)
                {
                    flag=true;}
                 for(int l=i;l<arr1.length;l++){
                    if(map.get(arr1[l])>=2)
                    {flag=true;
                     break;
                    }
                 }
                int x=arr1.length-i;
                if(!flag)
                swap+=x;
                map.put(arr2[j],map.get(arr2[j])+x);
                for(int l=i;l<arr1.length;l++)
                    map.put(arr1[l],map.get(arr1[l])+1);
                arr[k++]=arr2[j++];
            }
        }
        while(i<arr1.length){
            arr[k++]=arr1[i++];
        }
         while(j<arr2.length){
            arr[k++]=arr2[j++];
        }

        if(!flag)
        return swap;
        return -1;
    }
	public static int solve(Integer[] arr,int start,int end,HashMap<Integer,Integer> map){
        int out=0;
        if(start<end){
            int mid=(start+end)/2;
            int a=solve(arr,start,mid, map);
            if(a==-1)
                return -1;
            int b=solve(arr,mid+1,end, map);
             if(b==-1)
                return -1;
        	int c=merge(arr,start,mid,end, map);
             if(c==-1)
                return -1;
            out=a+b+c;
        }
        return out;
    }
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
        int size=in.nextInt();
        Integer[] arr=new Integer[size];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<size;i++){
            arr[i]=in.nextInt();
            map.put(arr[i],0);
        }
        int x=solve(arr,0,arr.length-1,map);
        if(x>0){
            System.out.println("YES\n"+x);
        }
        else
            System.out.println("NO");
       
	}

}