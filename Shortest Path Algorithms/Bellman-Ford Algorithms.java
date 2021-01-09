import java.util.*;
import java.lang.*;
import java.io.*;
class list{
    int src;
    int dst;
    int wt;
    list(int s, int d, int w){
        src = s;
        dst = d;
        wt = w;
    }
}

class GFG {
	public static void main (String[] args) {
	   Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            list[] li = new list[m];
            int i, j, change =0;
            for(i=0;i<m;i++)
		{
                int u = sc.nextInt();
                int v = sc.nextInt();
                int w = sc.nextInt();
                li[i] = new list(u, v, w);
            }
            
            int[] dist = new int[n+1];
            for(i=0;i<n;i++)
            {
                dist[i] = Integer.MAX_VALUE;
            }
                dist[0] = 0;
            	for(i=0;i<n-1;i++)
		{
                for(j = 0; j<m;j++)
		{
                    if(dist[li[j].dst] > dist[li[j].src] + li[j].wt)
                        dist[li[j].dst] = dist[li[j].src] + li[j].wt;
                }
           	}
            	for(j =0; j<m;j++)
		{
                if(dist[li[j].dst] > dist[li[j].src] + li[j].wt)
		{
                   dist[li[j].dst] = dist[li[j].src] + li[j].wt;
                   change++;
                }
            }
            if(change>0)
		{
			System.out.println("shortest distance is not calcultad");
		}
		else
		{
			 printArr(dist, n); 
		}
	} 
	void printArr(int dist[], int V) 
    	{ 
        System.out.println("Vertex Distance from Source"); 
        for (int i = 0; i < V; ++i) 
            System.out.println(i + "\t\t" + dist[i]); 
   	 } 
	
	   
}
}
