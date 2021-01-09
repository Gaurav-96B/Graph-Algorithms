import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static int  dfs(int a[][],int x,int y,int visited[][])
    {
        if(x<0||x>=a.length||y<0||y>=a.length||a[x][y]==0||visited[x][y]==1)
        {
            return 0;
        }
        if(a[x][y]==2)
        {
            return 1;
        }
        visited[x][y]=1;
        return dfs(a,x-1,y,visited)|dfs(a,x+1,y,visited)|dfs(a,x,y-1,visited)|dfs(a,x,y+1,visited);
        
    }
	public static void main (String[] args) {
	    int t;
	    Scanner sc=new Scanner(System.in);
	    t=sc.nextInt();
	    sc.nextLine();
	    while(t-->0)
	    {
	        int n=sc.nextInt();
	        int a[][]=new int[n][n];
	        int row=0;
	        int column=0;
	        for(int i=0;i<n;i++)
	        {
	            for(int j=0;j<n;j++)
	            {
	                a[i][j]=sc.nextInt();
	                if(a[i][j]==1)
	                {
	                    row=i;
	                    column=j;
	                }
	            }
	        }
	        int visited[][]=new int[n][n];
	        for(int i=0;i<n;i++)
	        {
	            for(int j=0;j<n;j++)
	            {
	                visited[i][j]=0;
	            }
	        }
	        int z=dfs(a,row,column,visited);
	        if(z==0)
	        {
	            System.out.println("0");
	        }
	        else
	        {
	            System.out.println("1");
	        }
	    }
	}
}
