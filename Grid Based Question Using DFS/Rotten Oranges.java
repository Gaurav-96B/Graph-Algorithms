import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
     static class Pair
     {
         int x;
         int y;
         Pair(int x,int y)
         {
             this.x=x;
             this.y=y;
         }
     }
    static int rotten(int a[][])
    {
        int total=0;
        int time=0;
        int rotten=0;
        Queue<Pair>q=new LinkedList<>();
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a[0].length;j++)
            {
                if(a[i][j]==1||a[i][j]==2)
                {
                   total++; 
                }
                if(a[i][j]==2)
                {
                    q.add(new Pair(i,j));
                }
            }
        }
        if(total==0)
        {
            return 0;
        }
        while(!q.isEmpty())
        {
            int size=q.size();
            rotten=rotten+size;
            if(rotten==total)
            {
                return time;
            }
            time++;
        for(int i=0;i<size;i++)
        {
            Pair p=q.peek();
            if(p.x+1<a.length&&a[p.x+1][p.y]==1)
            {
                a[p.x+1][p.y]=2;
               q.add(new Pair(p.x+1,p.y));
            }
            if(p.x-1>=0&&a[p.x-1][p.y]==1)
            {
                a[p.x-1][p.y]=2;
               q.add(new Pair(p.x-1,p.y));
            }
            if(p.y+1<a[0].length&&a[p.x][p.y+1]==1)
            {
                a[p.x][p.y+1]=2;
               q.add(new Pair(p.x,p.y+1));
            }
            if(p.y-1>=0&&a[p.x][p.y-1]==1)
            {
                a[p.x][p.y-1]=2;
               q.add(new Pair(p.x,p.y-1));
            }
            q.poll();
            
        }
        
        }
        return -1;
    }
	public static void main (String[] args) {
	    int t;
	    Scanner sc=new Scanner(System.in);
	    t=sc.nextInt();
	    sc.nextLine();
	    while(t-->0)
	    {
	        int r=sc.nextInt();
	        int c=sc.nextInt();
	        int a[][]=new int[r][c];
	        for(int i=0;i<r;i++)
	        {
	            for(int j=0;j<c;j++)
	            {
	                a[i][j]=sc.nextInt();
	            }
	        }
	        System.out.println(rotten(a));
	    }
	}
}
