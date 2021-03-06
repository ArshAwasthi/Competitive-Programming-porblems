//Largest Piece
//
//Its Gary's birthday today and he has ordered his favourite square cake consisting of '0's and '1's . But Gary wants the biggest piece of '1's and no '0's . A piece of cake is defined as a part which consist of only '1's, and all '1's share an edge with eachother on the cake. Given the size of cake N and the cake , can you find the size of the biggest piece of '1's for Gary ?
//Constraints :
//1<=N<=50
//Input Format :
//Line 1 : An integer N denoting the size of cake 
//Next N lines : N characters denoting the cake
//Output Format :
//Size of the biggest piece of '1's and no '0's
//Sample Input :
//2
//11
//01
//Sample Output :
//3


public class solution {
    
    public int get(boolean[][] graph,boolean[][] visited,int r,int c){
        if(!graph[r][c]||r>=graph.length||c>=graph[0].length)
            return 0;
        visited[r][c]=true;
        int out=1;
        if(c+1<graph[0].length&&!visited[r][c+1]){
            out+=get(graph,visited,r,c+1);
            
        }
        if(r+1<graph.length&&!visited[r+1][c]){
            out+=get(graph,visited,r+1,c);
        }
		if(r-1>=0&&!visited[r-1][c]){
		out+=get(graph,visited,r-1,c);
		}
		if(c-1>=0&&!visited[r][c-1]){
		out+=get(graph,visited,r,c-1);
		}
        return out;
        
    }
    public int solve(int n,String cake[]) {
        //write your code here
        boolean[][] graph=new boolean[n][n];
        boolean[][] visited=new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
         		if(cake[i].charAt(j)=='1')
                    graph[i][j]=true;
            }
        }
    	int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(graph[i][j]){
                int piece=get(graph,visited,i,j);
                    
                    for(int x=0;x<n;x++){
            for(int y=0;y<n;y++)
                        visited[x][y]=false;
                        }
                if(max<piece)
                    max=piece;
                }
            }
        }    
        return max;
    }
}
