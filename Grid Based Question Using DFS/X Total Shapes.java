import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
		    int m=sc.nextInt();
		    int n=sc.nextInt();
		    char grid[][]=new char[m][n];
		    for(int i=0;i<m;i++)
		    {
		        String s=sc.next();
		        char ch[]=s.toCharArray();
		        for(int j=0;j<ch.length;j++)
		        {
		            grid[i][j]=ch[j];
		        }
		    }
		    int count=0;
		    for(int i=0;i<m;i++)
		      for(int j=0;j<grid[0].length;j++)
		            if(grid[i][j]=='X')
		                count+=dfs(grid,i,j);
		          System.out.println(count);      
		}
	}
	public static int dfs(char[][] grid,int i,int j)
	{
	    if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]=='O')
	    return 0;
	    
	    grid[i][j]='O';
	    dfs(grid,i+1,j);
	    dfs(grid,i,j+1);
	     dfs(grid,i-1,j);
	    dfs(grid,i,j-1);
	    return 1;
	}
}
