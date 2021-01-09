import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
	    int t;
	    Scanner sc=new Scanner(System.in);
	    t=sc.nextInt();
	    sc.nextLine();
	    while(t-->0)
	    {
	        int v=sc.nextInt();
	        int e=sc.nextInt();
	       ArrayList<ArrayList<Integer>>adj=new ArrayList<ArrayList<Integer> >(v);
	       for(int i=0;i<v;i++)
	       {
	          adj.add(new ArrayList<>());
	       }
	       int n=0;
	       int m=0;
	       for(int i=0;i<e;i++)
	       {
	           n=sc.nextInt();
	           m=sc.nextInt();
	           adj.get(n).add(m);
	       }
	       int z=0;
	       for(int i=0;i<v;i++)
	       {
	            z=z+adj.get(i).size();
	       }
	       System.out.print(z);
	       System.out.println();
	    }
	}
}
