import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
	        int V=sc.nextInt();
	        int graph[][]=new int[V][V];
	        for(int i=0;i<V;i++)
	        for(int j=0;j<V;j++)
	            graph[i][j]=sc.nextInt();
	        findDist(graph,V);
	    }
	}
	static void findDist(int graph[][],int V){
	    int INF=10000000;
	    int i,j,k;
	    for(k=0;k<V;k++)
	    for(i=0;i<V;i++)
	    for(j=0;j<V;j++)
	    graph[i][j]=Math.min(graph[i][j],graph[i][k]+graph[k][j]);
	    printDist(graph);
	}
	static void printDist(int[][] graph){
	    int n=graph.length;
	    int INF=10000000;
	    for(int i=0;i<n;i++){
	        for(int j=0;j<n;j++){
	            if(graph[i][j]==INF)
	            System.out.print("INF ");
	            else
	            System.out.print(graph[i][j]+" ");
	        }
	        System.out.println();
	    }
	}
}
